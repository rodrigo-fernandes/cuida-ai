package com.rodrigo.project.crud.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rodrigo.project.crud.user.service.UserCRUDService;
import com.rodrigo.project.model.user.UserEntity;

/* @author Rodrigo Fernandes */

@Controller
public class UserCRUDController {

	UserCRUDService userService;

	@GetMapping("/user")
	public String getUser(Model model) {
		model.addAttribute("user", new UserEntity());

		return "user";
	}

	@PostMapping("/user")
	public String userSubmit(@ModelAttribute UserEntity user) {

		return "result";

	}

}
