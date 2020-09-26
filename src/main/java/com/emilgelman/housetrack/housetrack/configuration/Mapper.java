package com.emilgelman.housetrack.housetrack.configuration;


import com.emilgelman.housetrack.housetrack.api.AddAlertRequestDTO;
import com.emilgelman.housetrack.housetrack.services.alerts.AddAlertRequest;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    AddAlertRequest fromDto(AddAlertRequestDTO addAlertRequestDTO);
}
