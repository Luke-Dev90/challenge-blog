package com.challenge.alkemy.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.challenge.alkemy.blog.model.Posteo;
import com.challenge.alkemy.blog.service.PosteoService;

@Controller
public class PosteoController {

	@Autowired
	private PosteoService posteoService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", posteoService.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if(id != null && id!=0) {
			model.addAttribute("posteo", posteoService.get(id));
		}else {
			model.addAttribute("posteo", new Posteo());
		}
		return "save";
	}
	
	@GetMapping("/save")
	public String save(Posteo posteo, Model model) {
		posteoService.save(posteo);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id,Model model) {
		posteoService.delete(id);
		return "delete";
	}
}
