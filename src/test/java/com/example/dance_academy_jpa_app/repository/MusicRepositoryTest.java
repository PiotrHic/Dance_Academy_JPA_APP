package com.example.dance_academy_jpa_app.repository;


import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.domain.Music;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MusicRepositoryTest {

    @Autowired
    MusicRepository musicRepository;

    Music first = Music.builder()
                .nameOfTheSong("test1")
                .build();


    Music second = Music.builder()
            .nameOfTheSong("test2")
            .build();

    @BeforeEach
    void setUp(){
        musicRepository.deleteAll();
    }


    @Test
    void createMusic(){
        long count = musicRepository.count();

        assertThat(count).isEqualTo(0);

        musicRepository.save(first);

        count = musicRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void getAllMusic(){
        long count = musicRepository.count();

        assertThat(count).isEqualTo(0);

        musicRepository.save(first);
        musicRepository.save(second);

        count = musicRepository.findAll().size();
        assertThat(count).isEqualTo(2);
    }

    @Test
    void getOneDanceMusic(){

        long count = musicRepository.count();

        assertThat(count).isEqualTo(0);

        DanceInstructor saved = musicRepository.save(first);

        count = musicRepository.count();

        assertThat(count).isEqualTo(1);

        DanceInstructor founded = musicRepository.getReferenceById(first.getId());

        assertThat(founded.getName()).isEqualTo("test1");


    }

    @Test
    void deleteMusicById(){

        long count = musicRepository.count();

        assertThat(count).isEqualTo(0);

        musicRepository.save(first);

        count = musicRepository.count();

        assertThat(count).isEqualTo(1);

        musicRepository.deleteById(first.getId());

        count = musicRepository.count();

        assertThat(count).isEqualTo(0);
    }


    @Test
    void deleteAllMusic() {
        long count = musicRepository.count();

        assertThat(count).isEqualTo(0);

        musicRepository.save(first);
        musicRepository.save(second);

        count = musicRepository.count();

        assertThat(count).isEqualTo(2);

        musicRepository.deleteAll();

        count = musicRepository.count();

        assertThat(count).isEqualTo(0);

    }
}
