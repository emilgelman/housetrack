package com.emilgelman.housetrack.housetrack.services.yad2;

import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class Yad2Controller {
    private final Yad2Service service;

    @GetMapping(path = "/yad2")
    public List<House> get()
    {
        log.info("Received new yad2 get request");
        return service.retrieve(new HouseRetrievalRequest());
    }
}
