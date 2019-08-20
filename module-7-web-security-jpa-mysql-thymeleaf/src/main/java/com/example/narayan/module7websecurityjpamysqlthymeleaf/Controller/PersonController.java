package com.example.narayan.module7websecurityjpamysqlthymeleaf.Controller;

import com.example.narayan.module7websecurityjpamysqlthymeleaf.PersonService;
import com.example.narayan.module7websecurityjpamysqlthymeleaf.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonService personService;
	
	private ArrayList personModelList;
	
	private List personList=null;
	
	@PostMapping(value="/")
	public String addperson(@RequestParam("name") String name,
							@RequestParam("id") Integer id,
							Model model) {
		personService.addPerson( "Nary", 10000 );
		personService.addPerson( "Pary", 10001 );
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/")
	public String personhome(
			@RequestParam(value = "search", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")
			Model model) {
		
		personModelList   = new ArrayList();
		
		
		model.addAttribute("search", personModelList);
		model.addAttribute("dogs", personRepository.findAll());
		
	
		return "index";
	}
}
