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
@Table(name = "Dancer_Table")
@Entity
public class Dancer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dancer_id", nullable = false)
    private Integer id;

    @Column(name = "dancer_name", nullable = false, unique = true)
    private String name;

    @Column(name = "dancer_age")
    private int age;

    @Column(name = "dancer_sex", updatable=false)
    private String sex;
}