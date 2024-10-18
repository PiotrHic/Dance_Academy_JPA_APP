package com.example.dance_academy_jpa_app.repository;

import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.repositories.DancerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DancerRepositoryTest {

    @Autowired
    DancerRepository dancerRepository;

    Dancer first = Dancer.builder()
            .name("test1")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test1")
            .lastModifiedBy("test1")
            .age(1)
            .build();

    Dancer second = Dancer.builder()
            .name("test2")
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .createdBy("test2")
            .lastModifiedBy("test2")
            .age(2)
            .build();

    @BeforeEach
    void setUp(){
        dancerRepository.deleteAll();
    }


    @Test
    void createDancer(){
        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(first);

        count = dancerRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void getAllDancers(){
        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(first);
        dancerRepository.save(second);

        count = dancerRepository.findAll().size();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void getOneDancerById(){

        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        Dancer saved = dancerRepository.save(first);

        count = dancerRepository.count();

        assertThat(count).isEqualTo(1);

        Dancer founded = dancerRepository.getReferenceById(first.getId());

        assertThat(founded.getName()).isEqualTo("test1");


    }

    @Test
    void deleteDancerById(){

        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(first);

        count = dancerRepository.count();

        assertThat(count).isEqualTo(1);

        dancerRepository.deleteById(first.getId());

        count = dancerRepository.count();

        assertThat(count).isEqualTo(0);
    }


    @Test
    void deleteAllDancersId() {
        long count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

        dancerRepository.save(first);
        dancerRepository.save(second);

        count = dancerRepository.count();

        assertThat(count).isEqualTo(2);

        dancerRepository.deleteAll();

        count = dancerRepository.count();

        assertThat(count).isEqualTo(0);

    }

}
