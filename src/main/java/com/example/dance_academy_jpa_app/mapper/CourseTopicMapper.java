package com.example.dance_academy_jpa_app.mapper;

import com.example.dance_academy_jpa_app.domain.CourseTopic;
import com.example.dance_academy_jpa_app.dto.CourseTopicDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseTopicMapper {

    public CourseTopicDTO courseTopicTocourseTopicDTO(CourseTopic courseTopic){

        return CourseTopicDTO.builder()
                .id(courseTopic.getId())
                .name(courseTopic.getName())
                .build();
    }

    public CourseTopic courseTopicToCourseTopicDTOr(CourseTopicDTO courseTopicDTO){
        return CourseTopic.builder()
                .id(courseTopicDTO.getId())
                .name(courseTopicDTO.getName())
                .build();
    }
}
