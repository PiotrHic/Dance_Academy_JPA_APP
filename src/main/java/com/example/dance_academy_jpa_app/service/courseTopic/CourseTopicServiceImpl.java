package com.example.dance_academy_jpa_app.service.courseTopic;

import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.exception.JPAEntityNotFoundException;
import com.example.dance_academy_jpa_app.repositories.CourseTopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseTopicServiceImpl implements CourseTopicService {

    private final CourseTopicRepository courseTopicRepository;
    @Override
    public CourseTopic createTopic(CourseTopic courseTopic) {
        return courseTopicRepository.save(courseTopic);
    }

    @Override
    public CourseTopic getCourseTopic(Integer id) {
        if(!courseTopicRepository.existsById(id)){
            throw new JPAEntityNotFoundException("Course Topic with id " + id + " was not found!");
        }
        return courseTopicRepository.getById(id);
    }

    @Override
    public List<CourseTopic> getAllCourseTopics() {
        return courseTopicRepository.findAll();
    }

    @Override
    public CourseTopic updateCourseTopic(Integer id, CourseTopic courseTopic) {

        if(!courseTopicRepository.existsById(id)){
            throw new JPAEntityNotFoundException("Course Topic with id " + id + " was not found!");
        }

        CourseTopic toUpdate = courseTopicRepository.getById(id);
        toUpdate.setName(courseTopic.getName());
        toUpdate.setDanceCourse(courseTopic.getDanceCourse());
        toUpdate.setCreatedAt(courseTopic.getCreatedAt());
        toUpdate.setCreatedBy(courseTopic.getCreatedBy());
        toUpdate.setLastModifiedAt(courseTopic.getLastModifiedAt());
        toUpdate.setLastModifiedBy(courseTopic.getLastModifiedBy());
        return courseTopicRepository.save(toUpdate);
    }

    @Override
    public String deleteCourseTopicByID(Integer id) {

        if(!courseTopicRepository.existsById(id)){
            throw new JPAEntityNotFoundException("Course Topic with id " + id + " was not found!");
        }

        CourseTopic deleted = courseTopicRepository.getById(id);
        String result = "Course Topic with id: " + deleted.getId() + " and name: " + deleted.getName() + " was deleted!";
        courseTopicRepository.deleteById(id);
        return result;
    }

    @Override
    public void deleteAllCourseTopics() {
        courseTopicRepository.deleteAll();
    }
}
