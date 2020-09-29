package com.emilgelman.housetrack.housetrack;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import org.junit.jupiter.api.Test;

public class IntegTest extends AbstractIntegTestBase {

    @Test
    public void setup() {
        alertRepository.deleteAll();
        Alert denia = Alert.builder()
                .city("haifa")
                .neighborhood("savyoni-hacarmel")
                .roomsFrom(4L)
                .roomsTo(5L)
                .priceFrom(1000000L)
                .priceTo(2000000L)
                .build();

        Alert neot = Alert.builder()
                .city("haifa")
                .neighborhood("neot-peres")
                .roomsFrom(4L)
                .roomsTo(5L)
                .priceFrom(1000000L)
                .priceTo(2000000L)
                .build();

        alertRepository.save(denia);
        alertRepository.save(neot);
    }
}
