package com.emilgelman.housetrack.housetrack.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Data
@Configuration
@ConfigurationProperties(prefix = "house-track")
public class HousetrackProperties {
    public final Yad2 yad2 = new Yad2();

    @Data
    public static class Yad2 {
        private Map<String,String> cities = new HashMap<>();
        private Map<String,String> neighborhoods = new HashMap<>();
    }
}
