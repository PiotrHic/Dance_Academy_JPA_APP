package com.example.dance_academy_jpa_app.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MusicTest {

    Music music = Music.builder()
                .nameOfTheSong("Happy")
                .build();

    @Test
    public void setNameOfTheSong(){
        // given
        String expected = "Sappy";
        // when
        music.setNameOfTheSong(expected);
        // then
        Assertions.assertEquals(expected, music.getNameOfTheSong());
    }

    @Test
    public void getNameOfTheSong(){
        // given
        String expected = "Qando";
        // when
        music.setNameOfTheSong(expected);
        // then
        Assertions.assertEquals(expected, music.getNameOfTheSong());
    }
}
