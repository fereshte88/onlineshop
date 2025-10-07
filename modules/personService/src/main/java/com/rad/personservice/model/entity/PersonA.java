package com.rad.personservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_PERSON_A")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PersonA  extends BasePerson<PersonA>{

    @Column(name = "first_Name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    @Column(name="national_Code")
    private String nationalCode;
}
