package com.rodrigo.project.crud.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.project.crud.person.repository.PersonCRUDRepository;
import com.rodrigo.project.model.person.PersonEntity;

/* @author Rodrigo Fernandes */

@Service
public class PersonCRUDService {

	@Autowired
	private PersonCRUDRepository personCRUDRepository;

	public List<PersonEntity> findAll() {
		return personCRUDRepository.findAll();
	}

	public PersonEntity findOnde(Long id) {
		return personCRUDRepository.findById(id).get();
	}

	public PersonEntity save(PersonEntity personEntity) {
		return personCRUDRepository.save(personEntity);
	}

	public void delete(PersonEntity id) {
		personCRUDRepository.delete(id);
	}

}
