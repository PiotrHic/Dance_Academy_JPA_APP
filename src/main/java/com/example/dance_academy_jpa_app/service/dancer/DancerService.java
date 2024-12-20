package com.example.dance_academy_jpa_app.service.dancer;

import com.example.dance_academy_jpa_app.domain.Dancer;

import java.util.List;

public interface DancerService {


    Dancer createDancer(Dancer dancer);

    Dancer getDancer (Integer id);
    List<Dancer> getAllDancers();

    Dancer updateDancer (Integer id, Dancer dancer);

    String deleteDancer (Integer id);
    void deleteAllDancers ();
}
