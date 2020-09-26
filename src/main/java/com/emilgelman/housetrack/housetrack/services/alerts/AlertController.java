package com.emilgelman.housetrack.housetrack.services.alerts;

import com.emilgelman.housetrack.housetrack.api.AddAlertRequestDTO;
import com.emilgelman.housetrack.housetrack.configuration.Mapper;
import com.emilgelman.housetrack.housetrack.domain.Alert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class AlertController {
    private final AlertService service;
    private final Mapper mapper;

    @GetMapping(path = "/alerts")
    public List<Alert> get()
    {
        log.info("Received get all alerts request");
        return service.getAlerts();
    }

    @PutMapping(path = "/alerts")
    public void add(@RequestBody AddAlertRequestDTO addAlertRequestDTO)
    {
        log.info("Received add alert request {}", addAlertRequestDTO);
        service.addAlert(mapper.fromDto(addAlertRequestDTO));
    }

    @DeleteMapping(path = "/alerts")
    public void delete()
    {
        log.info("Received delete all request");
        service.deleteAll();
    }
}
