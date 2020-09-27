package com.emilgelman.housetrack.housetrack;

import com.emilgelman.housetrack.housetrack.repository.AlertRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("integ")
@SpringBootTest
public abstract class AbstractIntegTestBase {
    @Autowired
    protected AlertRepository alertRepository;

//    @AfterEach
//    public void tearDown()
//    {
//        alertRepository.deleteAll();
//    }
}
