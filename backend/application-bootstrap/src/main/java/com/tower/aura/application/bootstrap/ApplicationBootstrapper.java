package com.tower.aura.application.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class ApplicationBootstrapper {
    public static void main(String[] args) {
        run(ApplicationBootstrapper.class, args);
    }
}