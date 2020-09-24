package com.emilgelman.housetrack.housetrack.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class House {
    private String id;
    private Long price;
    private String city;
    private String neighborhood;
    private String street;
    private Long rooms;
}
