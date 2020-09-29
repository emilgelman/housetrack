package com.emilgelman.housetrack.housetrack.domain;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Alert {
    @Id
    private String id;
    private String city;
    private String neighborhood;
    private Long roomsFrom;
    private Long roomsTo;
    private Long priceFrom;
    private Long priceTo;
    @Builder.Default
    private Set<House> houses = new HashSet<>();
}