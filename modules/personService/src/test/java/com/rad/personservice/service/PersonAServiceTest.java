package com.rad.personservice.service;



import com.rad.personservice.model.dto.PersonADto;
import com.rad.personservice.model.entity.PersonA;
import com.rad.personservice.model.repository.PersonARepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PersonAServiceTest {

    @InjectMocks
    private PersonAService personAService;

    @Mock
    private PersonARepository personARepository;


    @Test
    void save() {
        // Given
        PersonADto PersonADto = new PersonADto("FirstName", "LastName", "1234567890");
        PersonA savedPersonA = new PersonA();
        savedPersonA.setId(1L);
        savedPersonA.setFirstName("FirstName");
        savedPersonA.setLastName("LastName");
        savedPersonA.setNationalCode("1234567890");

        // Use any() matcher instead of specific object
        when(personARepository.save(any())).thenReturn(savedPersonA);

        // When
        PersonA result = personAService.save(PersonADto);

        // Then
        assertNotNull(result);
        assertEquals("FirstName", result.getFirstName());
        assertEquals("LastName", result.getLastName());
        assertEquals("1234567890", result.getNationalCode());
        assertEquals(1L, result.getId());

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }


    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}