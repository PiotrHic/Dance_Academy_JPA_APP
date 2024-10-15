package com.example.dance_academy_jpa_app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DancerDTO {

    private Integer id;
    private String name;
    private int age;
    private String sex;
}
