package com.example.dance_academy_jpa_app.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DanceMoveTest {

    DanceMove danceMove = DanceMove.builder()
            .typeOfTheMove("Twist")
            .build();

    @Test
    public void setTypeOfTheMove(){
        // given
        String expected = "Flip";
        // when
        danceMove.setTypeOfTheMove(expected);
        // then
        Assertions.assertEquals(expected, danceMove.getTypeOfTheMove());
    }

    @Test
    public void getTypeOfTheMove(){
        // given
        String expected = "Jump";
        // when
        danceMove.setTypeOfTheMove(expected);
        // then
        Assertions.assertEquals(expected, danceMove.getTypeOfTheMove());
    }
}
