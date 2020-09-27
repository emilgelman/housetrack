package com.emilgelman.housetrack.housetrack;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import com.emilgelman.housetrack.housetrack.domain.House;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class IntegTest extends AbstractIntegTestBase {

    @Test
    public void setup() {
        alertRepository.deleteAll();
        Alert denia = Alert.builder()
                .city("haifa")
                .neighborhood("savyoni-denia")
                .roomsFrom(2L)
                .roomsTo(3L)
                .priceFrom(1000000L)
                .priceTo(2000000L)
                .houses(generateMocks("savyoni-denia"))
                .build();

        Alert neot = Alert.builder()
                .city("haifa")
                .neighborhood("neot-peres")
                .roomsFrom(2L)
                .roomsTo(3L)
                .priceFrom(1000000L)
                .priceTo(2000000L)
                .houses(generateMocks("neot-peres"))
                .build();

        alertRepository.save(denia);
        alertRepository.save(neot);
    }

    private Set<House> generateMocks(String neighborhood) {
        Set<House> result = new HashSet<>();
        for (int i=0;i<5;i++)
        {
            result.add(House.builder()
            .city("haifa")
            .neighborhood(neighborhood)
            .rooms((long)i)
            .price(i*1000000L)
            .id(String.valueOf(i))
            .build());
        }
        return result;
    }
}
