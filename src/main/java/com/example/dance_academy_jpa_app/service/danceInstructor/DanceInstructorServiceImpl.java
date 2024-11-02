package com.example.dance_academy_jpa_app.service.danceInstructor;

import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.exception.JPAEntityNotFoundException;
import com.example.dance_academy_jpa_app.repositories.DanceInstructorRepository;
import com.example.dance_academy_jpa_app.service.courseTopic.CourseTopicServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DanceInstructorServiceImpl implements DanceInstructorService {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DanceInstructorServiceImpl.class);

    private final DanceInstructorRepository danceInstructorRepository;
    @Override
    public DanceInstructor createDanceInstructor(DanceInstructor danceInstructor) {
        return danceInstructorRepository.save(danceInstructor);
    }

    @Override
    public DanceInstructor getDanceInstructor(Integer id) {
        if(!danceInstructorRepository.existsById(id)){
            LOGGER.info("Dance Instructor Topic was not found!");
            throw new JPAEntityNotFoundException("Dance Instructor with id: " + id + " was not found!");
        }
        return danceInstructorRepository.getById(id);
    }

    @Override
    public List<DanceInstructor> getAllDanceInstructors() {
        return danceInstructorRepository.findAll();
    }

    @Override
    public DanceInstructor updateDanceInstructor(Integer id, DanceInstructor danceInstructor) {
        if(!danceInstructorRepository.existsById(id)){
            LOGGER.info("Dance Instructor Topic was not found!");
            throw new JPAEntityNotFoundException("Dance Instructor with id: " + id + " was not found!");
        }
        DanceInstructor toUpdate = danceInstructorRepository.getReferenceById(id);
        toUpdate.setName(danceInstructor.getName());
        toUpdate.setName(danceInstructor.getName());
        toUpdate.setDanceCourse(danceInstructor.getDanceCourse());
        toUpdate.setCreatedAt(danceInstructor.getCreatedAt());
        toUpdate.setCreatedBy(danceInstructor.getCreatedBy());
        toUpdate.setLastModifiedAt(danceInstructor.getLastModifiedAt());
        toUpdate.setLastModifiedBy(danceInstructor.getLastModifiedBy());
        return danceInstructorRepository.save(toUpdate);
    }

    @Override
    public String deleteDanceInstructor(Integer id) {
        if(!danceInstructorRepository.existsById(id)){
            LOGGER.info("Dance Instructor Topic was not found!");
            throw new JPAEntityNotFoundException("Dance Instructor with id: " + id + " was not found!");
        }
        DanceInstructor deleted = danceInstructorRepository.getById(id);
        String result = "Dance Instructor with the id: " + deleted.getId()
                + " and name: " + deleted.getName() + "was deleted";
        danceInstructorRepository.deleteById(id);
        return result;
    }

    @Override
    public void deleteAllDanceInstructors() {
        danceInstructorRepository.deleteAll();
    }
}
