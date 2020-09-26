package com.emilgelman.housetrack.housetrack.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAlertRequestDTO {
    private String city;
    private String neighborhood;
    private Long roomsFrom;
    private Long roomsTo;
    private Long priceFrom;
    private Long priceTo;
}
