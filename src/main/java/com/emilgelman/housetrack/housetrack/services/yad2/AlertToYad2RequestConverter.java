package com.emilgelman.housetrack.housetrack.services.yad2;

import com.emilgelman.housetrack.housetrack.configuration.HousetrackProperties;
import com.emilgelman.housetrack.housetrack.domain.Alert;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlertToYad2RequestConverter {
    private final HousetrackProperties properties;

    public HouseRetrievalRequest convert(Alert alert)
    {
        return HouseRetrievalRequest.builder()
                .city(properties.getYad2().getCities().get(alert.getCity()))
                .neighborhood(properties.getYad2().getNeighborhoods().get(alert.getNeighborhood()))
                .priceFrom(alert.getPriceFrom())
                .priceTo(alert.getPriceTo())
                .roomsFrom(alert.getRoomsFrom())
                .roomsTo(alert.getRoomsTo())
                .build();
    }
}
