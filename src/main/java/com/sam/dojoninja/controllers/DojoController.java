package com.sam.dojoninja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sam.dojoninja.models.Dojo;
import com.sam.dojoninja.services.DojoServ;


@Controller
public class DojoController {

	@Autowired
	private DojoServ dojoServ;
	
//	@GetMapping("/")
//	public String main( ) {
//		return"redirect:/dojo";
//	}
	
//	RENDER DISPLAY PAGE FOR NEW DOJO
	@GetMapping("/dojo")
	public String newDojoPage(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojo/new.jsp";
	}
	
	
	@GetMapping("/dojo/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojo/oneDojo.jsp";
	}
	
	
//	POST METHOD FOR NEW DOJO
	@PostMapping("/munkie")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "/dojo/new.jsp";
		}else {
		dojoServ.createDojo(dojo);
			return "redirect:/dojo";
		}
	}
}
