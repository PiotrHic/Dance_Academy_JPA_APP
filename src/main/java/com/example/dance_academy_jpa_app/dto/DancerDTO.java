package com.example.dance_academy_jpa_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DancerDTO {

    private Integer id;
    private String name;
    private int age;
    private String sex;
}
