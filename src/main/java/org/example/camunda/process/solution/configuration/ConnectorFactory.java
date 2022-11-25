package org.example.camunda.process.solution.configuration;

import org.example.camunda.process.solution.worker.LegacySystemConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectorFactory {
    @Bean
    public LegacySystemConnector legacySystemConnector() {
        return new LegacySystemConnector();
    }
}