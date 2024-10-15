package com.example.dance_academy_jpa_app.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "Dance_Course_Table")
@Entity
public class DanceCourse extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dance_course_id",nullable = false)
    private Integer id;

    @Column(name = "dance_course_name", nullable = false, unique = true)
    private String name;

}
