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
@Table(name = "Dance_Instructor_Table")
@Entity
public class DanceInstructor extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dance_instructor_id", nullable = false)
    private Integer id;

    @Column(name = "dance_instructor_name", nullable = false, unique = true)
    private String name;

    @Column(name = "Years_Of_Experience")
    private int yearsOfExperience;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dance_course_id")
    private DanceCourse danceCourse;
}
