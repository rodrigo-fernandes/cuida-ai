package com.rodrigo.project.crud.state.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rodrigo.project.crud.state.service.StateCRUDService;
import com.rodrigo.project.model.state.StateEntity;

/* @author Rodrigo Fernandes */

@Controller
public class StateCRUDController {

	@Autowired

	// private StateCRUDRepository crudRepository;

	private StateCRUDService stateCRUDService;

	/*
	 * public StateCRUDController(StateCRUDRepository crudRepository) {
	 * this.crudRepository = crudRepository; }
	 */

	@GetMapping("/state")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/state");
		mv.addObject("posts", stateCRUDService.findAll());

		return mv;
	}

	// Lista os estados cadastrados
	/*
	 * @RequestMapping("/state") public String getStates(Model model) {
	 * model.addAttribute("statesList", this.crudRepository.findAll());
	 * 
	 * return "state"; }
	 */

	@GetMapping("/addstate")
	public ModelAndView add(StateEntity stateEntity) {

		ModelAndView mv = new ModelAndView("/stateAdd");
		mv.addObject("state", stateCRUDService);

		return mv;
	}

	@GetMapping("/editstate/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(stateCRUDService.findOnde(id));
	}

	@GetMapping("/deletestate/{id}")
	public ModelAndView delete(@PathVariable("id") StateEntity id) {

		stateCRUDService.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid StateEntity stateEntity, BindingResult result) {

		if (result.hasErrors()) {
			return add(stateEntity);
		}

		stateCRUDService.save(stateEntity);

		return findAll();
	}

}
