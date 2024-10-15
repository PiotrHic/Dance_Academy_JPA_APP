package com.example.dance_academy_jpa_app.mapper;

import com.example.dance_academy_jpa_app.domain.DanceInstructor;
import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.dto.DanceInstructorDTO;
import com.example.dance_academy_jpa_app.dto.DancerDTO;
import org.springframework.stereotype.Component;

@Component
public class DanceInstructorMapper {

    public DanceInstructorDTO danceInstructorToDanceInstructorDTO(DanceInstructor danceInstructor){

        return DanceInstructorDTO.builder()
                .id(danceInstructor.getId())
                .name(danceInstructor.getName())
                .yearsOfExperience(danceInstructor.getYearsOfExperience())
                .build();
    }

    public DanceInstructor danceInstructorDTOToDanceInstructor(DanceInstructorDTO danceInstructorDTO){
        return DanceInstructor.builder()
                .id(danceInstructorDTO.getId())
                .name(danceInstructorDTO.getName())
                .yearsOfExperience(danceInstructorDTO.getYearsOfExperience())
                .build();
    }
}
