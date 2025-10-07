package com.rad.personservice.model.repository;

import com.rad.personservice.model.entity.PersonC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCRepository extends JpaRepository<PersonC,Long> {
}
