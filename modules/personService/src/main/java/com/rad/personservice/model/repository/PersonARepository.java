package com.rad.personservice.model.repository;


import com.rad.personservice.model.entity.PersonA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonARepository extends JpaRepository<PersonA,Long> {
}
