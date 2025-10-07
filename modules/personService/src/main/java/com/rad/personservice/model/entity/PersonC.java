package com.rad.personservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PERSON_C")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonC extends BasePerson<PersonC>{

    @Column(name="name")
    private String name;

    @Column(name="register_Number")
    private String registerNumber;

    @Column(name="registerDate")
    private String registerDate;

    @Column(name="nationalId")
    private String nationalId;

}
