package com.example.dance_academy_jpa_app.domain;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DanceMove extends CourseTopic{

    private String typeOfTheMove;
}
