package com.rad.personservice.model.repository;

import com.rad.personservice.model.entity.PersonB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonBRepository extends JpaRepository<PersonB,Long> {
}
