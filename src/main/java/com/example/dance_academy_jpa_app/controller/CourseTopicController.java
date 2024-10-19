package com.example.dance_academy_jpa_app.controller;


import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.dto.CourseTopicDTO;
import com.example.dance_academy_jpa_app.dto.DancerDTO;
import com.example.dance_academy_jpa_app.mapper.CourseTopicMapper;
import com.example.dance_academy_jpa_app.service.courseTopic.CourseTopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "It adds a new Course Topic to the database")
    @ApiResponse(responseCode = "201",
            description = "Add new Course Topic to the database",
            content = {@Content(mediaType =  "application/json")})
    @PostMapping
    ResponseEntity<CourseTopicDTO> createCourseTopic(@RequestBody CourseTopicDTO courseTopicDTO){
        CourseTopic toSave = courseTopicService
                .createTopic(courseTopicMapper.courseTopicDTOToCourseTopic(courseTopicDTO));

        return new ResponseEntity<>(courseTopicMapper.courseTopicToCourseTopicDTO(toSave),
                HttpStatus.valueOf(201));
    }
    @Operation(summary = "It updates Course Topic with the new data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update Course Topic to the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Course Topic was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @PutMapping(API_PATH_ID)
    ResponseEntity <CourseTopicDTO> updateCourseTopicById(@PathVariable(ID_PATH) Integer courseTopicID,
                                                     @RequestBody CourseTopicDTO courseTopicDTO) {
        CourseTopic updated = courseTopicService.updateCourseTopic(courseTopicID,
                courseTopicMapper.courseTopicDTOToCourseTopic(courseTopicDTO));
        return new ResponseEntity<>(courseTopicMapper.courseTopicToCourseTopicDTO(updated), HttpStatus.OK);
    }

    @Operation(summary = "It brings one Course Topic from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get one Course Topic from the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Course Topic was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @GetMapping(API_PATH_ID)
    ResponseEntity <CourseTopicDTO> getCourseTopicById(@PathVariable(ID_PATH) Integer courseTopicID) {
        CourseTopic founded = courseTopicService.getCourseTopic(courseTopicID);
        return new ResponseEntity<>(courseTopicMapper.courseTopicToCourseTopicDTO(founded), HttpStatus.OK);
    }
    @Operation(summary = "Takes all Course Topics from the database")
    @ApiResponse(responseCode = "200",
            description = "Gives all Course Topics from the database",
            content = {@Content(mediaType =  "application/json")})
    @GetMapping
    ResponseEntity <List<CourseTopicDTO>> getCourseTopics(){
        List<CourseTopicDTO> courseTopicDTOs = courseTopicService
                .getAllCourseTopics()
                .stream()
                .map(courseTopicMapper::courseTopicToCourseTopicDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(courseTopicDTOs, HttpStatus.OK);
    }

    @Operation(summary = "It deletes one Course Topics from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Deletes one Course Topics from the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Course Topics was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @DeleteMapping(API_PATH_ID)
    ResponseEntity <String> deleteCourseTopicById(@PathVariable(ID_PATH) Integer courseTopicID){
        String deleted = courseTopicService.deleteCourseTopicByID(courseTopicID);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @Operation(summary = "Deletes all Course Topics from the database")
    @ApiResponse(responseCode = "200",
            description = "Deletes all Course Topics from the database",
            content = {@Content(mediaType =  "application/json")})
    @DeleteMapping()
    ResponseEntity <String> deleteAllDancers(){
        courseTopicService.deleteAllCourseTopics();
        return new ResponseEntity<>("Database is empty", HttpStatus.OK);
    }

}
