package com.rad.personservice.model.dto;

import com.rad.personservice.model.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonADto {

    private long id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private List<Job> jobs;
}
