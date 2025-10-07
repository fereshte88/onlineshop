package com.rad.personservice.service;


import com.rad.personservice.model.dto.PersonADto;
import com.rad.personservice.exception.ResourceNotFoundException;
import com.rad.personservice.model.entity.PersonA;
import com.rad.personservice.model.repository.PersonARepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonAService {

    private final PersonARepository personARepository;

    public PersonAService(PersonARepository personARepository) {
        this.personARepository = personARepository;
    }

    public Optional<PersonA> findById(long id) {
       return Optional.ofNullable(personARepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id)));
    }

    public List<PersonA> findAll() {
        List<PersonA> PersonAList = personARepository.findAll();
        return PersonAList.isEmpty() ? new ArrayList<>() : PersonAList;
    }

    public PersonA save(PersonADto personADto) {
        PersonA personA = PersonA.builder().firstName(personADto.getFirstName())
                                                    .lastName(personADto.getLastName())
                                                    .nationalCode(personADto.getNationalCode())
                                                    .createAt(new Date(System.currentTimeMillis()))
                                                    .build();
        return personARepository.save(personA);
    }

    public PersonA update(PersonADto personADto,Long id) {
        Optional<PersonA> personA = personARepository.findById(id);

        if (personA.isPresent()) {
            PersonA editPersonA = personA.get();
            if (personADto.getFirstName() != null) {
                editPersonA.setFirstName(personADto.getFirstName());
            }
            if (personADto.getLastName() != null) {
                editPersonA.setLastName(personADto.getLastName());
            }
            if (personADto.getNationalCode() != null) {
                editPersonA.setNationalCode(personADto.getNationalCode());
            }
            editPersonA.setUpdateAt(new Date(System.currentTimeMillis()));
            personARepository.save(editPersonA);
            return editPersonA;
        } else {
            throw new RuntimeException("Teacher with id" + id + "not found.");
        }

    }
    public PersonA deleteById(long id) {
        PersonA personA = this.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
       personARepository.deleteById(id);
       return personA;
    }

}
