package com.example.dance_academy_jpa_app.service.danceInstructor;


import com.example.dance_academy_jpa_app.domain.DanceInstructor;

import java.util.List;

public interface DanceInstructorService {

    DanceInstructor createDanceInstructor(DanceInstructor danceInstructor);

    DanceInstructor getDanceInstructor (Integer id);
    List<DanceInstructor> getAllDanceInstructors();

    DanceInstructor updateDanceInstructor (Integer id, DanceInstructor danceInstructor);

    String deleteDanceInstructor (Integer id);
    void deleteAllDanceInstructors();
}
