package com.emilgelman.housetrack.housetrack;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.repository.AlertRepository;
import com.emilgelman.housetrack.housetrack.services.alerts.AlertUpdater;
import com.emilgelman.housetrack.housetrack.services.yad2.Yad2Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class Yad2Test extends AbstractIntegTestBase{

    @Autowired
    AlertUpdater alertUpdater;

    @MockBean
    Yad2Service yad2Service;

    @BeforeEach
    public void setUp()
    {
        alertRepository.save(alert);
    }

    private final Alert alert = buildAlert();

    private Alert buildAlert() {
        return Alert.builder()
                .city("haifa")
                .neighborhood("savyoni-denya")
                .roomsFrom(1L)
                .roomsTo(2L)
                .priceFrom(100L)
                .priceTo(200L)
                .build();
    }

    @Test
    public void whenNoNewHousesExpectEmpty() {
        when(yad2Service.retrieve(any())).thenReturn(Collections.emptySet());
        alertUpdater.processAlert(alert);
        assertThat(alert.getHouses()).isEmpty();
    }

    @Test
    public void whenPreviousIsEmptyExpectNewSize() {
        House house = House.builder().id("1").build();
        when(yad2Service.retrieve(any())).thenReturn(Set.of(house));
        alertUpdater.processAlert(alert);
        assertThat(alert.getHouses()).containsExactly(house);
    }

    @Test
    public void whenHouseWasSoldExpectEmpty()
    {
        House house = House.builder().id("1").build();
        when(yad2Service.retrieve(any())).thenReturn(Set.of(house));
        alertUpdater.processAlert(alert);
        when(yad2Service.retrieve(any())).thenReturn(Collections.emptySet());
        alertUpdater.processAlert(alert);
        assertThat(alert.getHouses()).isEmpty();
    }

    @Test
    public void updateExistingHousePrice()
    {
        House house = House.builder().id("1").price(10L).build();
        when(yad2Service.retrieve(any())).thenReturn(Set.of(house));
        alertUpdater.processAlert(alert);
        house.setPrice(20L);
        alertUpdater.processAlert(alert);
        assertThat(alert.getHouses()).containsExactly(house);
    }

}
