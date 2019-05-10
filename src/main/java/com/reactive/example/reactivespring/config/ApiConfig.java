package com.reactive.example.reactivespring.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Ehtiram_Abdullayev on 09.05.2019
 * @project reactivespring
 */

@Configuration
public class ApiConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    @Bean
    public ObjectWriter objectWriter(ObjectMapper mapper){
        return mapper.writerWithDefaultPrettyPrinter();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector()).build();
    }
}
