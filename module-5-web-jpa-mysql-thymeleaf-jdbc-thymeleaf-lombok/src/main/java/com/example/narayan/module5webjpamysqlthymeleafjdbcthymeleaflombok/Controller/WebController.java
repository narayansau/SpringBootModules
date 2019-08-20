package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Controller;


import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices.Sequence1SqDAOImplimentation;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices.SequenceDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class WebController{
	
	private  List<PersonEntity> persons = new ArrayList <PersonEntity>();
	private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public WebController(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	
	private PersonEntityController_CRUD cont = new PersonEntityController_CRUD(namedParameterJdbcTemplate);
	private SequenceDaoService sequenceDaoService=new SequenceDaoService(  namedParameterJdbcTemplate );
	Sequence1SqDAOImplimentation sequence1SqDAOImplimentation ; //=
			//new  Sequence1SqDAOImplimentation();
	
		
	
	
	// Inject via application.properties
	@Value("${welcome.message}")
	private String message;
	
	@Value("${error.message}")
	private String errorMessage;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("message", message);
		
		return "index";
	}
	
	@RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
	public String personList(Model model) {
		System.out.println( "My sequence is AAAAA "  );
		
		//persons.add (cont.setPersonEntity() );
	//	 	persons.add (cont.setPersonEntity() );
		model.addAttribute("persons", persons);
		
		return "personList";
	}
	/************
	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
	public String showAddPersonPage(Model model) {
		
		PersonForm personForm = new PersonForm();
		model.addAttribute("personForm", personForm);
		
		return "addPerson";
	}
	
	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
	public String savePerson(Model model, //
							 @ModelAttribute("personForm") PersonForm personForm) {
		
		String firstName = personForm.getFirstName();
		String lastName = personForm.getLastName();
		
		if (firstName != null && firstName.length() > 0 //
				&& lastName != null && lastName.length() > 0) {
			Person newPerson = new Person(firstName, lastName);
			persons.add(newPerson);
			
			return "redirect:/personList";
		}
		model.addAttribute("errorMessage", errorMessage);
		return "addPerson";
	}
	*****************/
}

