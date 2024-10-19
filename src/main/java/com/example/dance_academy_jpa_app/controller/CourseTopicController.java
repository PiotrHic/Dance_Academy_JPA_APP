package com.example.dance_academy_jpa_app.controller;


import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.dto.CourseTopicDTO;
import com.example.dance_academy_jpa_app.dto.DancerDTO;
import com.example.dance_academy_jpa_app.mapper.CourseTopicMapper;
import com.example.dance_academy_jpa_app.service.courseTopic.CourseTopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/courseTopics")
public class CourseTopicController {

    private final CourseTopicService courseTopicService;
    private final CourseTopicMapper courseTopicMapper;

    private final String API_PATH_ID = "/{courseTopicID}";
    private final String ID_PATH = "courseTopicID";

    @PostMapping
    ResponseEntity<CourseTopicDTO> createCourseTopic(@RequestBody CourseTopicDTO courseTopicDTO){
        CourseTopic toSave = courseTopicService
                .createTopic(courseTopicMapper.courseTopicDTOToCourseTopic(courseTopicDTO));

        return new ResponseEntity<>(courseTopicMapper.courseTopicToCourseTopicDTO(toSave),
                HttpStatus.valueOf(201));
    }
    @PutMapping(API_PATH_ID)
    ResponseEntity <CourseTopicDTO> updateCourseTopicById(@PathVariable(ID_PATH) Integer courseTopicID,
                                                     @RequestBody CourseTopicDTO courseTopicDTO) {
        CourseTopic updated = courseTopicService.updateCourseTopic(courseTopicID,
                courseTopicMapper.courseTopicDTOToCourseTopic(courseTopicDTO));
        return new ResponseEntity<>(courseTopicMapper.courseTopicToCourseTopicDTO(updated), HttpStatus.OK);
    }

    @GetMapping(API_PATH_ID)
    ResponseEntity <CourseTopicDTO> getCourseTopicById(@PathVariable(ID_PATH) Integer courseTopicID) {
        CourseTopic founded = courseTopicService.getCourseTopic(courseTopicID);
        return new ResponseEntity<>(courseTopicMapper.courseTopicToCourseTopicDTO(founded), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity <List<CourseTopicDTO>> getCourseTopics(){
        List<CourseTopicDTO> courseTopicDTOs = courseTopicService
                .getAllCourseTopics()
                .stream()
                .map(courseTopicMapper::courseTopicToCourseTopicDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(courseTopicDTOs, HttpStatus.OK);
    }

    @DeleteMapping(API_PATH_ID)
    ResponseEntity <String> deleteCourseTopicById(@PathVariable(ID_PATH) Integer courseTopicID){
        String deleted = courseTopicService.deleteCourseTopicByID(courseTopicID);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity <String> deleteAllDancers(){
        courseTopicService.deleteAllCourseTopics();
        return new ResponseEntity<>("Database is empty", HttpStatus.OK);
    }

}
