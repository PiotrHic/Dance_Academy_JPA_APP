package com.example.dance_academy_jpa_app.repository;

import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.domain.DanceMove;
import com.example.dance_academy_jpa_app.domain.Music;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DanceMoveRepositoryTest {

    @Autowired
    DanceMoveRepository danceMoveRepository;

    DanceMove first = DanceMove.builder()
            .typeOfTheMove("test1")
            .build();


    DanceMove second = DanceMove.builder()
            .typeOfTheMove("test2")
            .build();

    @BeforeEach
    void setUp(){
        danceMoveRepository.deleteAll();
    }


    @Test
    void createDanceMove(){
        long count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);

        danceMoveRepository.save(first);

        count = danceMoveRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void getAllMusic(){
        long count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);

        danceMoveRepository.save(first);
        danceMoveRepository.save(second);

        count = danceMoveRepository.findAll().size();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void getOneDanceMusic(){

        long count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);

        DanceInstructor saved = danceMoveRepository.save(first);

        count = danceMoveRepository.count();

        assertThat(count).isEqualTo(1);

        DanceInstructor founded = danceMoveRepository.getReferenceById(first.getId());

        assertThat(founded.getName()).isEqualTo("test1");


    }

    @Test
    void deleteDanceMoveById(){

        long count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);

        danceMoveRepository.save(first);

        count = danceMoveRepository.count();

        assertThat(count).isEqualTo(1);

        danceMoveRepository.deleteById(first.getId());

        count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);
    }


    @Test
    void deleteAllDanceMoves() {
        long count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);

        danceMoveRepository.save(first);
        danceMoveRepository.save(second);

        count = danceMoveRepository.count();

        assertThat(count).isEqualTo(2);

        danceMoveRepository.deleteAll();

        count = danceMoveRepository.count();

        assertThat(count).isEqualTo(0);

    }
}
