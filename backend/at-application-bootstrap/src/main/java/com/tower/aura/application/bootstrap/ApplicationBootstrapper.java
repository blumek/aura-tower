package com.tower.aura.application.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;

@ComponentScan("com.tower.aura")
@ConfigurationPropertiesScan("com.tower.aura")
@EnableConfigurationProperties
@SpringBootApplication
public class ApplicationBootstrapper {
    public static void main(String[] args) {
        run(ApplicationBootstrapper.class, args);
    }
}