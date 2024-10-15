package com.example.dance_academy_jpa_app;

import org.springframework.boot.SpringApplication;

public class TestDanceAcademyJpaAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(DanceAcademyJpaAppApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
