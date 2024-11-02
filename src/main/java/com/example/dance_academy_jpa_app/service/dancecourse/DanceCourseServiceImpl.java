package com.example.dance_academy_jpa_app.service.dancecourse;


import com.example.dance_academy_jpa_app.domain.DanceCourse;
import com.example.dance_academy_jpa_app.exception.JPAEntityNotFoundException;
import com.example.dance_academy_jpa_app.repositories.DanceCourseRepository;
import com.example.dance_academy_jpa_app.service.courseTopic.CourseTopicServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DanceCourseServiceImpl implements DanceCourseService {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DanceCourseServiceImpl.class);

    private final DanceCourseRepository danceCourseRepository;
    @Override
    public DanceCourse createDanceCourse(DanceCourse danceCourse) {
        return danceCourseRepository.save(danceCourse);
    }

    @Override
    public DanceCourse getDanceCourse(Integer id) {
        if(!danceCourseRepository.existsById(id)){
            LOGGER.info("Dance Course Topic was not found!");
            throw new JPAEntityNotFoundException("Dance Course with id: " + id + " was not found!");
        }
        return danceCourseRepository.getReferenceById(id);
    }

    @Override
    public List<DanceCourse> getAllDanceCourses() {
        return danceCourseRepository.findAll();
    }

    @Override
    public DanceCourse updateDanceCourse(Integer id, DanceCourse danceCourse) {

        if(!danceCourseRepository.existsById(id)){
            LOGGER.info("Dance Course Topic was not found!");
            throw new JPAEntityNotFoundException("Dance Course with id: " + id + " was not found!");
        }
        DanceCourse toUpdate = danceCourseRepository.getReferenceById(id);
        toUpdate.setName(danceCourse.getName());
        toUpdate.setName(danceCourse.getName());
        toUpdate.setDanceInstructors(danceCourse.getDanceInstructors());
        toUpdate.setCreatedAt(danceCourse.getCreatedAt());
        toUpdate.setCreatedBy(danceCourse.getCreatedBy());
        toUpdate.setLastModifiedAt(danceCourse.getLastModifiedAt());
        toUpdate.setLastModifiedBy(danceCourse.getLastModifiedBy());
        return danceCourseRepository.save(toUpdate);
    }

    @Override
    public String deleteDanceCourse(Integer id) {
        if(!danceCourseRepository.existsById(id)){
            LOGGER.info("Dance Course Topic was not found!");
            throw new JPAEntityNotFoundException("Dance Course with id: " + id + " was not found!");
        }
        DanceCourse deleted = danceCourseRepository.getReferenceById(id);
        String result = "Dance Course with id: " + deleted.getId() +" and name: " + deleted.getName() + " was deleted!";
        danceCourseRepository.deleteById(id);
        return result;
    }

    @Override
    public void deleteAllDanceCourses() {
        danceCourseRepository.deleteAll();
    }
}
