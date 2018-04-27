package com.rodrigo.project.crud.state.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodrigo.project.crud.state.repositoy.StateCRUDRepository;

/* @author Rodrigo Fernandes */

@Controller
public class StateCRUDController {

	@Autowired
	
	private StateCRUDRepository crudRepository;

	public StateCRUDController(StateCRUDRepository crudRepository) {
		this.crudRepository = crudRepository;
	}

	// Lista os estados cadastrados
	@RequestMapping("/state")
	public String getStates(Model model) {
		model.addAttribute("statesList", this.crudRepository.findAll());

		return "state";
	}

}
