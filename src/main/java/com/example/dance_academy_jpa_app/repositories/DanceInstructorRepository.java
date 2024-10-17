package com.example.dance_academy_jpa_app.repositories;

import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanceInstructorRepository extends JpaRepository<DanceInstructor, Integer> {
}
