package com.example.narayan.module3webjdbcmysqllombok.Controller;


import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import com.example.narayan.module3webjdbcmysqllombok.EntityServices.Person1SqDaoService;
import com.example.narayan.module3webjdbcmysqllombok.EntityServices.PersonDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;



@RestController
public class PersonEntityController{
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public PersonEntityController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
		
		
	}
	
	
 
	
@RequestMapping("/insert")
public String index() {
	
		int seqId ;
	
		// Entity Dao Services
	PersonDaoService personDaoService = new PersonDaoService( jdbcTemplate );
	Person1SqDaoService person1SqDaoService = new Person1SqDaoService(jdbcTemplate);
	PersonEntity personEntity = new PersonEntity();
	
	
	
	
	insert_locally_with_execute (  person1SqDaoService  );
	
	
	personEntity = setPersonEntity( personEntity , person1SqDaoService);
		
		
		personDaoService.savePersonWith_execute_Command(personEntity   );
	
	personEntity = setPersonEntity( personEntity , person1SqDaoService);
	
	    int i = personDaoService.savePersonWith_update_Command(personEntity);
		
	
		return "Data Inserted Successfully  " + i;
	}
	
	PersonEntity setPersonEntity(PersonEntity personEntity , Person1SqDaoService person1SqDaoService ) {
		
		
		
		int seqId ;
		
		seqId = person1SqDaoService.update_person_1sq();
		
		
		
		personEntity.setId( seqId );
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		
		cal.add(Calendar.YEAR, -20);
		Timestamp birhDate = new Timestamp(cal.getTime().getTime());
		
		personEntity.setEmail( "Nihgdgdgd@gmail.com" );
		personEntity.setName( "Sonali Sau" );
				personEntity.setPassword( "jhjhj" );
		personEntity.setRole( "User" );
				personEntity.setEnabled( (byte) 1 );
				
		personEntity.setBirthdate( birhDate  );
				personEntity.setCreated( timestamp );
		personEntity.setModified(  timestamp);
		
		return personEntity;
		
	}
	
	public void  insert_locally_with_execute ( Person1SqDaoService person1SqDaoService  ) {
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		
		int seqId = person1SqDaoService.update_person_1sq();
		
		
		
		
		jdbcTemplate.execute( "INSERT INTO person " +
				" (id," +
				"email," +
				"name," +
				"password," +
				"role," +
				"created," +
				"enabled) " +
				"VALUES  (" +  seqId  +
				" , 'NarayanSau@gmail.com', " +
				"'Sonali Chndra Sau'," +
				" 'bac123', " +
				"'ADMIN', '" +
				timestamp +
				"' , 1 )") ;
	}
	
}
