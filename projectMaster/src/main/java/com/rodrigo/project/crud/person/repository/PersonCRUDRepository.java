package com.rodrigo.project.crud.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.project.model.person.PersonEntity;

/* @author Rodrigo Fernandes */

public interface PersonCRUDRepository extends JpaRepository<PersonEntity, Long> {

}
