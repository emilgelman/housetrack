package com.emilgelman.housetrack.housetrack.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseRetrievalRequest {
    private String city;
    private String neighborhood;
    private Long priceFrom;
    private Long priceTo;
    private Long roomsFrom;
    private Long roomsTo;
}
