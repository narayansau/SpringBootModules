package com.example.narayan.module1onlythymeleaf.UserEntityController;


import com.example.narayan.module1onlythymeleaf.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserEntiryController{
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute User user) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "user-data" );
		modelAndView.addObject( "user", user );
		return  modelAndView;
	}
}
