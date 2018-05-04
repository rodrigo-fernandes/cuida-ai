package com.rodrigo.project.crud.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.project.crud.user.repository.UserCRUDRepository;
import com.rodrigo.project.model.user.UserEntity;

/* @author Rodrigo Fernandes */

@Service
public class UserCRUDService {

	@Autowired
	private UserCRUDRepository userCRUDRepository;

	public List<UserEntity> findAll() {
		return userCRUDRepository.findAll();
	}

	public UserEntity findOnde(Long id) {
		return userCRUDRepository.findById(id).get();
	}

	public UserEntity save(UserEntity stateEntity) {
		return userCRUDRepository.save(stateEntity);
	}

	public void delete(UserEntity id) {
		userCRUDRepository.delete(id);
	}
}
