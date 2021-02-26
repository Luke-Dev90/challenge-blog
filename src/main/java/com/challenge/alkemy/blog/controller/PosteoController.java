package com.challenge.alkemy.blog.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.challenge.alkemy.blog.model.Posteo;
import com.challenge.alkemy.blog.service.PosteoService;

@Controller
public class PosteoController {

	@Autowired
	private PosteoService posteoService;
	
	@RequestMapping("/home")
	public String index(Model model) {
		model.addAttribute("list", posteoService.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@Valid @PathVariable("id") Long id, Model model) {
		if(id != null && id!=0) {
			model.addAttribute("posteo", posteoService.get(id));
		}else {
			model.addAttribute("posteo", new Posteo());
		}
		return "save";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@Valid @PathVariable("id")  Long id, Model model) {
		if(id != null && id!=0) {
			model.addAttribute("posteo", posteoService.get(id));
		}else {
			model.addAttribute("posteo", new Posteo());
		}
		return "edit";
	}
	
	@PostMapping("/save")
	public String save( @RequestParam(name="file",required= false ) MultipartFile imagen, 
			@Valid Posteo posteo, Model model, RedirectAttributes flash,
			BindingResult result) throws IOException {
		
		if(result.hasErrors()) {
			System.out.println("Error en formulario");
			return "save";
		}
		
		if(!imagen.isEmpty()) {
			String ruta = "src/main/resources/static/uploads/";
			
				byte [] bytes = imagen.getBytes();
				Path rutaAbsoluta =  Paths.get(ruta + "//" + imagen.getOriginalFilename());
				Files.write(rutaAbsoluta,bytes);
				posteo.setImagen(imagen.getOriginalFilename());
 			
			posteoService.save(posteo);
			flash.addFlashAttribute("success", "foto subida");
		}
		
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id,Model model) {
		posteoService.delete(id);
		return "redirect:/home";
	}
}
