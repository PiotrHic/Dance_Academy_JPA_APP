package com.example.dance_academy_jpa_app.service.dancer;

import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.exception.JPAEntityNotFoundException;
import com.example.dance_academy_jpa_app.repositories.DancerRepository;
import com.example.dance_academy_jpa_app.service.courseTopic.CourseTopicServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DancerServiceImpl implements DancerService {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DancerServiceImpl.class);

    private final DancerRepository dancerRepository;
    @Override
    public Dancer createDancer(Dancer dancer) {
        return dancerRepository.save(dancer);
    }

    @Override
    public Dancer getDancer(Integer id) {
        if(!dancerRepository.existsById(id)){
            LOGGER.info("Dancer was not found!");
            throw new JPAEntityNotFoundException("Dancer with id: " + id + " was not found!");
        }
        return dancerRepository.getById(id);
    }


    @Override
    public List<Dancer> getAllDancers(){
        return dancerRepository.findAll();
    }
    @Override
    public Dancer updateDancer(Integer id, Dancer dancer) {
        if(!dancerRepository.existsById(id)){
            LOGGER.info("Dancer was not found!");
            throw new JPAEntityNotFoundException("Dancer with id: " + id + " was not found!");
        }
        Dancer toUpdate = dancerRepository.getReferenceById(id);
        toUpdate.setName(dancer.getName());
        toUpdate.setName(dancer.getName());
        toUpdate.setDanceCourses(dancer.getDanceCourses());
        toUpdate.setCreatedAt(dancer.getCreatedAt());
        toUpdate.setCreatedBy(dancer.getCreatedBy());
        toUpdate.setLastModifiedAt(dancer.getLastModifiedAt());
        toUpdate.setLastModifiedBy(dancer.getLastModifiedBy());
        return dancerRepository.save(toUpdate);
    }

    @Override
    public String deleteDancer(Integer id) {
        if(!dancerRepository.existsById(id)){
            LOGGER.info("Dancer was not found!");
            throw new JPAEntityNotFoundException("Dancer with id: " + id + " was not found!");
        }
        Dancer deleted = dancerRepository.getById(id);
        String result = "Dancer with id: " + deleted.getId() + " and name: " + deleted.getName() + " was deleted!";
        dancerRepository.deleteById(id);
        return result;
    }

    @Override
    public void deleteAllDancers() {
        dancerRepository.deleteAll();
    }
}
