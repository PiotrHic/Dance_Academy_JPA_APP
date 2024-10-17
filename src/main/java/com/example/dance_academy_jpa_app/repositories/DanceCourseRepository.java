package com.example.dance_academy_jpa_app.repositories;

import com.example.dance_academy_jpa_app.domain.DanceCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanceCourseRepository extends JpaRepository<DanceCourse,Integer> {
}