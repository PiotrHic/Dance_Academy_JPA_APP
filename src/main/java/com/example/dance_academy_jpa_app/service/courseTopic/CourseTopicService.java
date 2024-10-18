package com.example.dance_academy_jpa_app.service.courseTopic;

import com.example.dance_academy_jpa_app.domain.CourseTopic;

import java.util.List;

public interface CourseTopicService {

    CourseTopic createTopic(CourseTopic courseTopic);

    CourseTopic getCourseTopic(Integer id);

    List<CourseTopic> getAllCourseTopics();

    CourseTopic updateCourseTopic(Integer id, CourseTopic courseTopic);

    String deleteCourseTopicByID(Integer id);

    void deleteAllCourseTopics();
}
