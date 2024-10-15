package com.example.dance_academy_jpa_app.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DanceInstructorTest {

    // Test for id, name, yearsOfExperience

    DanceInstructor instructor = DanceInstructor
            .builder()
            .id(1)
            .name("test1")
            .yearsOfExperience(3)
            .build();

    @Test
    public void setId(){
        // given
        Integer expected = 10;
        // when
        instructor.setId(expected);
        // then
        Assertions.assertEquals(expected, instructor.getId());
    }

    @Test
    public void getId(){
        // given
        Integer expected = 10;
        // when
        instructor.setId(expected);
        // then
        Assertions.assertEquals(expected, instructor.getId());
    }

    @Test
    public void setName(){
        // given
        String expected = "name1";
        // when
        instructor.setName(expected);
        // then
        Assertions.assertEquals(expected, instructor.getName());
    }

    @Test
    public void getName(){
        // given
        String expected = "name2";
        // when
        instructor.setName(expected);
        // then
        Assertions.assertEquals(expected, instructor.getName());
    }

    @Test
    public void setYearsOfExperience(){
        // given
        int expected = 10;
        // when
        instructor.setYearsOfExperience(expected);
        // then
        Assertions.assertEquals(expected, instructor.getId());
    }

    @Test
    public void getYearsOfExperience(){
        // given
        Integer expected = 20;
        // when
        instructor.setYearsOfExperience(expected);
        // then
        Assertions.assertEquals(expected, instructor.getYearsOfExperience());
    }
}
