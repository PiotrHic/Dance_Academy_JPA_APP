package com.example.dance_academy_jpa_app.mapper;

import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.dto.DancerDTO;
import org.springframework.stereotype.Component;

@Component
public class DancerMapper {

    public DancerDTO dancerToDancerDTO(Dancer dancer){

        return DancerDTO.builder()
                .id(dancer.getId())
                .name(dancer.getName())
                .age(dancer.getAge())
                .sex(dancer.getSex())
                .build();
    }

    public Dancer dancerDTOToDancer(DancerDTO dancerDTO){
        return Dancer.builder()
                .id(dancerDTO.getId())
                .name(dancerDTO.getName())
                .age(dancerDTO.getAge())
                .sex(dancerDTO.getSex())
                .build();
    }
}
