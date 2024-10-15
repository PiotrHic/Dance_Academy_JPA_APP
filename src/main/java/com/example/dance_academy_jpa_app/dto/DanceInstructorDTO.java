package com.example.dance_academy_jpa_app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanceInstructorDTO {

    private Integer id;
    private String name;
    private int yearsOfExperience;
}
