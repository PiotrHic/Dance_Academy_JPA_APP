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
@Table(name = "Course_Topic_Table")
@Entity
public class CourseTopic extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_topic_id",nullable = false)
    private Integer id;

    @Column(name = "course_topic_name", nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "dance_course_id")
    private DanceCourse danceCourse;
}
