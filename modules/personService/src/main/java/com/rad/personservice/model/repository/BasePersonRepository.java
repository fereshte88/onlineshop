package com.rad.personservice.model.repository;

import com.rad.personservice.model.entity.BasePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasePersonRepository extends JpaRepository<BasePerson<?>, Long> {
}
