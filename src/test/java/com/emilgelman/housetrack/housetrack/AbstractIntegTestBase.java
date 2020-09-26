package com.emilgelman.housetrack.housetrack;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@Profile("integ")
@SpringBootTest
public abstract class AbstractIntegTestBase {
}
