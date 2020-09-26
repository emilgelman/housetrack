package com.emilgelman.housetrack.housetrack.services.update;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import com.emilgelman.housetrack.housetrack.services.alerts.AlertService;
import com.emilgelman.housetrack.housetrack.services.alerts.AlertUpdater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "house-track.scheduled.enabled", havingValue = "true")
public class ScheduledAlertUpdater {

    private final AlertUpdater alertUpdater;
    private final AlertService alertService;

    @Scheduled(fixedDelay = 600000) //10 min
    public void update() {
        List<Alert> alerts = alertService.getAlerts();
        alerts.forEach(alertUpdater::processAlert);
    }

}
