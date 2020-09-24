package com.emilgelman.housetrack.housetrack.services.yad2;

import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;
import com.emilgelman.housetrack.housetrack.services.abs.DataSourceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Yad2Service implements DataSourceService {
    private static final String API_URL = "https://www.yad2.co.il/api/pre-load/getFeedIndex/realestate/forsale";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public List<House> retrieve(HouseRetrievalRequest houseRetrievalRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json, text/plain, */*");
        headers.add("accept-language", "en-US,en;q=0.9");
        headers.add("sec-fetch-dest","empty");
        headers.add("sec-fetch-mode","cors");
        headers.add("sec-fetch-site","same-origin");
//        headers.add("cookie","_ga=GA1.3.1054036364.1589704923; __ssds=3; __ssuzjsr3=a9be0cd8e; __uzmaj3=902117c4-3671-4c75-b2a4-048d8d06836e; __uzmbj3=1589704925; UTGv2=h4769e5442cca30b2e146e7000f52a896b29; __uzma=89c3e2c1-1d93-476d-bcf6-8b29ca3fd8e2; __uzmb=1589705318; bc.visitorToken=6595405557304733696; leadSaleRentFree=41; y2m-cohort=64; USER_NAME=emil.gelman; uType_Car=0; uType_Nadlan=0; uType_yad2=0; _hjid=5a35d527-7b69-4883-8708-fd266ff6a4b6; uci=28a8aeb3a3d51f6719c1f9f3150a2bd5; USERNAME=emil.gelman%40gmail.com; SL_C_23361dd035530_KEY=7a1a33fc9daa7f4cae789de890c5df75154d3c61; mf_user=62745f481de702f25c1b2b59cb4a54e9|; login=202009041308; use_elastic_search=1; y2018-2-cohort=37; abTestKey=11; historyprimaryarea=north; historysecondaryarea=haifa; __uzmcj3=6873025312025; __uzmdj3=1600688105; canary=never; _gid=GA1.3.1134739417.1600965266; y2_cohort_2020=46; server_env=production; favorites_userid=iba258122583; _hjTLDTest=1; _hjAbsoluteSessionInProgress=0; __uzmc=71715438780094; __uzmd=1600965451; _gat_UA-708051-1=1");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        Map<String,String> params = new HashMap<>();
        params.put("city", "4000");
        params.put("neighborhood", "634");
        params.put("rooms","2-3");
        params.put("price","1400000-2000000");
        params.put("compact-req", "1");
        params.put("forceLdLoad","true");

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class, params);
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null)
        {
            throw new RuntimeException("Failed fetching data from yad2");
        }
        try {
            Yad2Response yad2Response = objectMapper.readValue(response.getBody(), Yad2Response.class);
            return yad2Response.getItems().stream()
                    .map(this::createHouse)
                    .collect(Collectors.toList());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private House createHouse(Yad2Response.FeedItem x) {
        return House.builder()
                .id(x.getId())
                .city(x.getCity())
                .neighborhood(x.getNeighborhood())
                .street(x.getStreet())
                .price(x.getPrice())
                .build();
    }
}
