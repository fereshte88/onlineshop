package com.rad.personservice.model.repository;


import com.rad.personservice.model.entity.PersonD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDRepository extends JpaRepository<PersonD,Long> {
}
