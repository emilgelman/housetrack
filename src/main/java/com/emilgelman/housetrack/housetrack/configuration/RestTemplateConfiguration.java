package com.emilgelman.housetrack.housetrack.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class RestTemplateConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .messageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
                .build();
    }
}
