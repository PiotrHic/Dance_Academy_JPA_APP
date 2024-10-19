package com.example.dance_academy_jpa_app.mapper;

import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.dto.CourseTopicDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseTopicMapper {

    public CourseTopicDTO courseTopicToCourseTopicDTO(CourseTopic courseTopic){

        return CourseTopicDTO.builder()
                .id(courseTopic.getId())
                .name(courseTopic.getName())
                .build();
    }

    public CourseTopic courseTopicDTOToCourseTopic(CourseTopicDTO courseTopicDTO){
        return CourseTopic.builder()
                .id(courseTopicDTO.getId())
                .name(courseTopicDTO.getName())
                .build();
    }
}
