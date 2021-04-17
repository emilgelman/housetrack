package com.emilgelman.housetrack.housetrack.services.alerts;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;
import com.emilgelman.housetrack.housetrack.services.yad2.AlertToYad2RequestConverter;
import com.emilgelman.housetrack.housetrack.services.yad2.Yad2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class AlertUpdater {

    private final Yad2Service yad2Service;
    private final AlertService alertService;
    private final AlertToYad2RequestConverter alertToYad2RequestConverter;

    public void processAlert(Alert alert) {
        log.info("Processing alert {}", alert);
        HouseRetrievalRequest request = alertToYad2RequestConverter.convert(alert);
        Set<House> houses = yad2Service.retrieve(request);
        updateAlertHouses(alert, houses);
        alertService.save(alert);
    }

    private void updateAlertHouses(Alert alert, Set<House> houses) {
        Set<House> previousHouses = alert.getHouses();
        Set<House> newHouses = new HashSet<>();
        for (House newHouse : houses) {
            if (!previousHouses.contains(newHouse)) {
                newHouses.add(newHouse);
            }
        }

        log.info("There are {} new houses for alert {}", newHouses.size(), alert);
        alert.setHouses(houses);
    }
}
