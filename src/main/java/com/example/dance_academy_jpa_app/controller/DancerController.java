package com.example.dance_academy_jpa_app.controller;

import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.dto.DancerDTO;
import com.example.dance_academy_jpa_app.mapper.DancerMapper;
import com.example.dance_academy_jpa_app.service.dancer.DancerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dancers")
public class DancerController {

    private final DancerService dancerService;

    private final DancerMapper dancerMapper;

    private final String API_PATH_ID = "/{dancerID}";
    private final String ID_PATH = "dancerID";

    @PostMapping
    ResponseEntity<DancerDTO> createDancer(@RequestBody DancerDTO dancerDTO){
        Dancer toSave = dancerService.createDancer(dancerMapper.dancerDTOToDancer(dancerDTO));

        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(toSave), HttpStatus.valueOf(201));
    }

    @PutMapping(API_PATH_ID)
    ResponseEntity <DancerDTO> updateDancerById(@PathVariable(ID_PATH) Integer dancerID, @RequestBody DancerDTO dancerDTO) {
        Dancer updated = dancerService.updateDancer(dancerID, dancerMapper.dancerDTOToDancer(dancerDTO));
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(updated), HttpStatus.OK);
    }

    @GetMapping(API_PATH_ID)
    ResponseEntity <DancerDTO> getDancerById(@PathVariable(ID_PATH) Integer dancerID) {
        Dancer founded = dancerService.getDancer(dancerID);
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(founded), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity <List<DancerDTO>> getAllDancers(){
        List<DancerDTO> dancerDTOs = dancerService
                .getAllDancers()
                .stream()
                .map(dancerMapper::dancerToDancerDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dancerDTOs, HttpStatus.OK);
    }

    @DeleteMapping(API_PATH_ID)
    ResponseEntity <String> deleteDancerById(@PathVariable(ID_PATH) Integer dancerID){
        String deleted = dancerService.deleteDancer(dancerID);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @DeleteMapping()
    ResponseEntity <String> deleteAllDancers(){
        dancerService.deleteAllDancers();
        return new ResponseEntity<>("Database is empty", HttpStatus.OK);
    }
}
