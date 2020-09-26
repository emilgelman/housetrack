package com.emilgelman.housetrack.housetrack.services.alerts;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import com.emilgelman.housetrack.housetrack.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {
    private final AlertRepository repository;

    public List<Alert> getAlerts()
    {
        return repository.findAll();
    }

    public void addAlert(AddAlertRequest request) {
        Alert alert = Alert.builder()
                .city(request.getCity())
                .neighborhood(request.getNeighborhood())
                .priceFrom(request.getPriceFrom())
                .priceTo(request.getPriceTo())
                .roomsFrom(request.getRoomsFrom())
                .roomsTo(request.getRoomsTo())
                .build();
        repository.save(alert);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void save(Alert alert) {
        repository.save(alert);
    }
}
