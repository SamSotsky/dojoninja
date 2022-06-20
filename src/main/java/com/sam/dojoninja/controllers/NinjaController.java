package com.sam.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sam.dojoninja.models.Dojo;
import com.sam.dojoninja.models.Ninja;
import com.sam.dojoninja.services.DojoServ;
import com.sam.dojoninja.services.NinjaServ;


@Controller
public class NinjaController {
	
	@Autowired
	private NinjaServ ninjaServ;
	@Autowired 
	private DojoServ dojoServ;
	
//	Render/ Display new ninjas
	@GetMapping("/ninjas/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninja/newNinja.jsp";
	}
	
	
//	=========ACTION TINGS====
//	url of each action TING must me the EXACT same in the form on jsp page bruv
	@PostMapping("/ninja/create")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "/ninja/newNinja.jsp";
		}else {
			ninjaServ.createNinja(ninja);
			return "redirect:/dojo";
		}
	}
	
	
	
}
