package com.example.dance_academy_jpa_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DanceAcademyJpaAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
