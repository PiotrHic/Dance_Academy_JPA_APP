package com.example.dance_academy_jpa_app.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DancerTest {

    // Tests for id, name, age, sex

    Dancer dancer = Dancer
            .builder()
            .id(1)
            .name("test1")
            .age(18)
            .sex("Male")
            .build();

    @Test
    public void setId(){
        // given
        Integer expected = 10;
        // when
        dancer.setId(expected);
        // then
        Assertions.assertEquals(expected, dancer.getId());
    }

    @Test
    public void getId(){
        // given
        Integer expected = 10;
        // when
        dancer.setId(expected);
        // then
        Assertions.assertEquals(expected, dancer.getId());
    }

    @Test
    public void setName(){
        // given
        String expected = "name";
        // when
        dancer.setName(expected);
        // then
        Assertions.assertEquals(expected, dancer.getName());
    }

    @Test
    public void getName(){
        // given
        String expected = "name1";
        // when
        dancer.setName(expected);
        // then
        Assertions.assertEquals(expected, dancer.getName());
    }

    @Test
    public void setAge(){
        // given
        int expected = 10;
        // when
        dancer.setAge(expected);
        // then
        Assertions.assertEquals(expected, dancer.getAge());
    }

    @Test
    public void getAge(){
        // given
        int expected = 20;
        // when
        dancer.setAge(expected);
        // then
        Assertions.assertEquals(expected, dancer.getAge());
    }

    @Test
    public void setSex(){
        // given
        String expected = "Male";
        // when
        dancer.setSex(expected);
        // then
        Assertions.assertEquals(expected, dancer.getSex());
    }

    @Test
    public void getSex(){
        // given
        String expected = "Female";
        // when
        dancer.setSex(expected);
        // then
        Assertions.assertEquals(expected, dancer.getSex());
    }
}
