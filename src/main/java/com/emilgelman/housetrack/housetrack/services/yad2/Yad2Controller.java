package com.emilgelman.housetrack.housetrack.services.yad2;

import com.emilgelman.housetrack.housetrack.configuration.HousetrackProperties;
import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class Yad2Controller {
    private final Yad2Service service;
    private final HousetrackProperties properties;

    @GetMapping(path = "/yad2")
    public List<House> get(@RequestParam Map<String,String> params)
    {
        log.info("Received new yad2 get request");
        HouseRetrievalRequest request = HouseRetrievalRequest.builder()
                .city(properties.getYad2().getCities().get(params.get("city")))
                .neighborhood(properties.getYad2().getNeighborhoods().get(params.get("neighborhood")))
                .priceFrom(Long.valueOf(params.get("price-from")))
                .priceTo(Long.valueOf(params.get("price-to")))
                .roomsFrom(Long.valueOf(params.get("rooms-from")))
                .roomsTo(Long.valueOf(params.get("rooms-to")))
                .build();
        return service.retrieve(request);
    }

}
