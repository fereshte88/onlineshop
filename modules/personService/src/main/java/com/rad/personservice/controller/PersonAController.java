package com.rad.personservice.controller;



import com.rad.personservice.model.dto.PersonADto;
import com.rad.personservice.model.dto.apiResponse.GenericResponse;
import com.rad.personservice.model.entity.PersonA;
import com.rad.personservice.service.PersonAService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonAController {

    private final PersonAService personAService;
    public PersonAController(PersonAService personAService){
        this.personAService=personAService;
    }

    @PostMapping("/create")
    public ResponseEntity<GenericResponse<PersonA>> createPersonA(@RequestBody PersonADto personADto){

        try {
            personAService.save(personADto);
            GenericResponse<PersonA> genericResponse = GenericResponse.<PersonA>success("Successfully Created");
            return ResponseEntity.status(HttpStatus.OK).body(genericResponse);

        } catch (Exception ex) {
            GenericResponse<PersonA> genericResponse = GenericResponse.<PersonA>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<GenericResponse<PersonA>> getAllPersonA(){

        try {
            List<PersonA> PersonAList = personAService.findAll();
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>builder().listData(PersonAList).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GenericResponse<PersonA>> getPersonAById(@PathVariable long id){

        try {
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>builder().data(personAService.findById(id).orElse(null)).build();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);

        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<GenericResponse<PersonA>> updatePersonA(@RequestBody PersonADto personADto, @PathVariable long id){

        try {
            personAService.update(personADto,id);
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>success("Successfully Created");
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse<PersonA>> deletePersonAById(@PathVariable long id){
        try {
            personAService.deleteById(id);
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>success("Successfully Created");
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        } catch (Exception ex) {
            GenericResponse<PersonA> apiResponse = GenericResponse.<PersonA>error("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
        }
    }

}
