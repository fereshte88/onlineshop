package com.rad.personservice.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PERSON_B")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonB extends BasePerson<PersonB> {

    @Column(name = "first_Name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

    @Column(name="public_Number")
    private String publicNumber;
}
