package com.rad.personservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonADto {

    private long id;
    private String firstName;
    private String lastName;
    private String nationalCode;
}
