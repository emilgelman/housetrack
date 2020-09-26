package com.emilgelman.housetrack.housetrack.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class House {
    @Id
    private String id;
    private Long price;
    private String city;
    private String neighborhood;
    private String street;
    private Long rooms;
}
