package com.example.dance_academy_jpa_app.controller;

import com.example.dance_academy_jpa_app.domain.Dancer;
import com.example.dance_academy_jpa_app.dto.DancerDTO;
import com.example.dance_academy_jpa_app.mapper.DancerMapper;
import com.example.dance_academy_jpa_app.service.dancer.DancerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dancers")
public class DancerController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DancerController.class);

    private final DancerService dancerService;

    private final DancerMapper dancerMapper;

    private final String API_PATH_ID = "/{dancerID}";
    private final String ID_PATH = "dancerID";

    @Operation(summary = "It adds a new Dancer to the database")
    @ApiResponse(responseCode = "201",
            description = "Add new Dancer to the database",
            content = {@Content(mediaType =  "application/json")})
    @PostMapping
    ResponseEntity<DancerDTO> createDancer(@RequestBody DancerDTO dancerDTO){
        Dancer toSave = dancerService.createDancer(dancerMapper.dancerDTOToDancer(dancerDTO));
        LOGGER.info("Dancer was saved in the DB : {}", toSave.getName());
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(toSave), HttpStatus.valueOf(201));
    }


    @Operation(summary = "It updates Dancer with the new data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update Dancer to the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Dancer was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @PutMapping(API_PATH_ID)
    ResponseEntity <DancerDTO> updateDancerById(@PathVariable(ID_PATH) Integer dancerID, @RequestBody DancerDTO dancerDTO) {
        Dancer updated = dancerService.updateDancer(dancerID, dancerMapper.dancerDTOToDancer(dancerDTO));
        LOGGER.info("Dancer was updated in the DB : {}", updated.getName());
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(updated), HttpStatus.OK);
    }

    @Operation(summary = "It brings one Dancer from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get one Dancer from the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Dancer was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @GetMapping(API_PATH_ID)
    ResponseEntity <DancerDTO> getDancerById(@PathVariable(ID_PATH) Integer dancerID) {
        Dancer founded = dancerService.getDancer(dancerID);
        LOGGER.info("Dancer was funded in the DB : {}", founded.getName());
        return new ResponseEntity<>(dancerMapper.dancerToDancerDTO(founded), HttpStatus.OK);
    }

    @Operation(summary = "Takes all Dancers from the database")
    @ApiResponse(responseCode = "200",
            description = "Gives all Dancers from the database",
            content = {@Content(mediaType =  "application/json")})
    @GetMapping
    ResponseEntity <List<DancerDTO>> getAllDancers(){
        List<DancerDTO> dancerDTOs = dancerService
                .getAllDancers()
                .stream()
                .map(dancerMapper::dancerToDancerDTO)
                .collect(Collectors.toList());
        LOGGER.info("All Dancers were found: size {}", dancerDTOs.size());
        return new ResponseEntity<>(dancerDTOs, HttpStatus.OK);
    }

    @Operation(summary = "It deletes one Dancer from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Deletes one dancer from the database",
                    content = {@Content(mediaType =  "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Dancer was not found in database",
                    content = {@Content(mediaType =  "application/json")}),
    })
    @DeleteMapping(API_PATH_ID)
    ResponseEntity <String> deleteDancerById(@PathVariable(ID_PATH) Integer dancerID){
        String deleted = dancerService.deleteDancer(dancerID);
        LOGGER.info("Dancer was deleted from the  DB : id {}", dancerID);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @Operation(summary = "Deletes all Dancers from the database")
    @ApiResponse(responseCode = "200",
            description = "Deletes all Dancers from the database",
            content = {@Content(mediaType =  "application/json")})
    @DeleteMapping()
    ResponseEntity <String> deleteAllDancers(){
        dancerService.deleteAllDancers();
        LOGGER.info("Dancers were deleted from the DB");
        return new ResponseEntity<>("Database is empty", HttpStatus.OK);
    }
}
