package com.rodrigo.project.crud.state.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.project.model.state.StateEntity;

/* @author Rodrigo Fernandes */

public interface StateCRUDRepository extends JpaRepository<StateEntity, Long> {

}
