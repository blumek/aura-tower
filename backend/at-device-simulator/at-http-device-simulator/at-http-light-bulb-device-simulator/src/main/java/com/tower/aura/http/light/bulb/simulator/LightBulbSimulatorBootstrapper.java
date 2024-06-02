package com.tower.aura.http.light.bulb.simulator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.run;

@EnableScheduling
@SpringBootApplication
public class LightBulbSimulatorBootstrapper {
    public static void main(String[] args) {
        run(LightBulbSimulatorBootstrapper.class, args);
    }
}