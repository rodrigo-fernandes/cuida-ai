package com.rodrigo.project.crud.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rodrigo.project.crud.person.service.PersonCRUDService;

/* @author Rodrigo Fernandes */

@Controller
public class PersonCRUDController {

	@Autowired
	private PersonCRUDService personCRUDService;

	// Lista as pessoas cadastradas
	@RequestMapping("/person")
	public String getStates(Model model) {
		model.addAttribute("personsList", this.personCRUDService.findAll());

		return "person";
	}

}
