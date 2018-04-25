package com.rodrigo.project.crud.state.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.project.crud.state.repositoy.StateCRUDRepository;
import com.rodrigo.project.model.state.StateEntity;

/* @author Rodrigo Fernandes */

@Service
public class StateCRUDService {

	@Autowired
	private StateCRUDRepository crudRepository;

	public List<StateEntity> findAll() {
		return crudRepository.findAll();
	}

	public StateEntity findOnde(Long id) {
		return crudRepository.findById(id).get();
	}

	public StateEntity save(StateEntity stateEntity) {
		return crudRepository.save(stateEntity);
	}

	public void delete(StateEntity id) {
		crudRepository.delete(id);
	}
}
