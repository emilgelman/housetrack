package com.emilgelman.housetrack.housetrack.services.yad2;

import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;
import com.emilgelman.housetrack.housetrack.services.abs.DataSourceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Yad2Service implements DataSourceService {
    private static final String API_URL = "https://www.yad2.co.il/api/pre-load/getFeedIndex/realestate/forsale?city={city}&neighborhood={neighborhood}&rooms={rooms}&price={price}&compact-req=1&forceLdLoad=true";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public Set<House> retrieve(HouseRetrievalRequest houseRetrievalRequest) {
        HttpEntity<String> entity = buildHttpEntity();
        Map<String, String> params = convertRequest(houseRetrievalRequest);


        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class, params);
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Failed fetching data from yad2");
        }
        try {
            Yad2Response yad2Response = objectMapper.readValue(response.getBody(), Yad2Response.class);
            return yad2Response.getItems().stream()
                    .map(this::createHouse)
                    .collect(Collectors.toSet());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }

    private Map<String, String> convertRequest(HouseRetrievalRequest houseRetrievalRequest) {
        Map<String, String> request = new HashMap<>();
        request.put("city", houseRetrievalRequest.getCity());
        request.put("neighborhood", houseRetrievalRequest.getNeighborhood());
        request.put("rooms", houseRetrievalRequest.getRoomsFrom() + "-" + houseRetrievalRequest.getRoomsTo());
        request.put("price", houseRetrievalRequest.getPriceFrom() + "-" + houseRetrievalRequest.getPriceTo());
        return request;
    }

    private House createHouse(Yad2Response.FeedItem x) {
        return House.builder()
                .id(x.getId())
                .city(x.getCity())
                .neighborhood(x.getNeighborhood())
                .street(x.getStreet())
                .rooms(x.getRooms())
                .squareMeters(x.getSquareMeters())
                .floor(x.getFloor())
                .price(x.getPrice())
                .street(x.getStreet())
                .sellerType(x.getSellerType())
                .dateAdded(x.getDateAdded())
                .parking(getParking(x.getId()))
                .build();
    }

    private Long getParking(String id) {
        HttpEntity<String> entity = buildHttpEntity();
        ResponseEntity<String> response = restTemplate.exchange("https://www.yad2.co.il/api/item/" + id, HttpMethod.GET, entity, String.class);
        try {
            ApiItemResponse apiItemResponse = objectMapper.readValue(response.getBody(), ApiItemResponse.class);
            return apiItemResponse.getParking();
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return 0L;
    }

    private HttpEntity<String> buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json, text/plain, */*");
        headers.add("accept-language", "en-US,en;q=0.9");
        headers.add("sec-fetch-dest", "empty");
        headers.add("sec-fetch-mode", "cors");
        headers.add("sec-fetch-site", "same-origin");
        return new HttpEntity<String>(headers);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ApiItemResponse {
        Long parking;
    }
}
