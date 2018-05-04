package com.rodrigo.project.crud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.project.model.user.UserEntity;

/* @author Rodrigo Fernandes */

public interface UserCRUDRepository extends JpaRepository<UserEntity, Long> {

}
