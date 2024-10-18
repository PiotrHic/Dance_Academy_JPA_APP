package com.example.dance_academy_jpa_app.mapper;


import com.example.dance_academy_jpa_app.domain.DanceCourse;
import com.example.dance_academy_jpa_app.dto.DanceCourseDTO;
import org.springframework.stereotype.Component;

@Component
public class DanceCourseMapper {

    public DanceCourseDTO danceCourseToDanceCourseDTO(DanceCourse danceCourse){

        return DanceCourseDTO.builder()
                .id(danceCourse.getId())
                .name(danceCourse.getName())
                .build();
    }

    public DanceCourse danceCourseDTOToDanceCourse(DanceCourseDTO danceCourseDTO){
        return DanceCourse.builder()
                .id(danceCourseDTO.getId())
                .name(danceCourseDTO.getName())
                .build();
    }
}
