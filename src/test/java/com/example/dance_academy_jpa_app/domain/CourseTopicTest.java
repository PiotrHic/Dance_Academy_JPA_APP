package com.example.dance_academy_jpa_app.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CourseTopicTest {

    CourseTopic danceTopic = CourseTopic.builder()
            .id(1)
            .name("test").build();
    @Test
    public void setId(){
        //given
        Integer expected = 10;
        //when
        danceTopic.setId(expected);
        //then
        Assertions.assertEquals(expected, danceTopic.getId());
    }

    @Test
    public void getId(){
        //given
        Integer expected = 10;
        //when
        danceTopic.setId(expected);
        //then
        Assertions.assertEquals(expected, danceTopic.getId());
    }

    @Test
    public void setName(){
        //given
        String expected = "name";
        //when
        danceTopic.setName(expected);
        //then
        Assertions.assertEquals(expected, danceTopic.getName());
    }

    @Test
    public void getName(){
        //given
        String expected = "name";
        //when
        danceTopic.setName(expected);
        //then
        Assertions.assertEquals(expected, danceTopic.getName());
    }
}
