package com.example.dance_academy_jpa_app.repositories;

import com.example.dance_academy_jpa_app.domain.CourseTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseTopicRepository extends JpaRepository<CourseTopic,Integer> {
}
