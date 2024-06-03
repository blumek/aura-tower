package com.tower.aura.application.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.run;

@ComponentScan("com.tower.aura")
@ConfigurationPropertiesScan("com.tower.aura")
@EnableConfigurationProperties
@EnableScheduling
@SpringBootApplication
public class ApplicationBootstrapper {
    public static void main(String[] args) {
        run(ApplicationBootstrapper.class, args);
    }
}