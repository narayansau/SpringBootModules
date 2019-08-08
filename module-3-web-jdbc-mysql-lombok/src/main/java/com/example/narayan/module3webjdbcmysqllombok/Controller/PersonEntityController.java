package com.example.narayan.module3webjdbcmysqllombok.Controller;


import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import com.example.narayan.module3webjdbcmysqllombok.EntityServices.Person1SqDaoService;
import com.example.narayan.module3webjdbcmysqllombok.EntityServices.PersonDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
 
	
//@RequestMapping("/insert")
@GetMapping("/insert")
public String variousInsertofDatainPersonTable() {
	
		int seqId ;
	
	/**********************
	 * // Entity Dao Services
	 * Genereally need to define all Entity DAo service and
	 * All Entity , and initialize them.
	 * If an Entity object does noy need any input data m that entity may not require to initialize here
	 **************************/
	
	PersonDaoService personDaoService = new PersonDaoService( jdbcTemplate );
	Person1SqDaoService person1SqDaoService = new Person1SqDaoService(jdbcTemplate);
	PersonEntity personEntity = new PersonEntity();
	
	
	
	// Premitive type insert into a table
	
	insert_locally_with_execute (  person1SqDaoService  );
	
	
	/*******************************
	 *  Want to insert row in a table
	 *  Set values of all required column of the entity
	 *  Call DaoService of those entities.
	 **********************************/
	personEntity = setPersonEntity( personEntity , person1SqDaoService);
		
		// Insert can be done by  executing DDL query.  with void reurn type
		personDaoService.savePersonWith_execute_Command(personEntity   );
	
	personEntity = setPersonEntity( personEntity , person1SqDaoService);
	
	
	// Insert can be done by  executing update query.  with  return type Integer
	// insert, update and delete records  can be done with this query
	//  return 1 is success.
	
	    int i = personDaoService.savePersonWith_update_Command(personEntity);
		
	
		return "Data Inserted Successfully  " + i;
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String DeleteDatainPersonTableById(@PathVariable int id) {
		
		PersonDaoService personDaoService = new PersonDaoService( jdbcTemplate );
		
		
		
		int i = personDaoService.deletePersonWithId(id)  ;
		
		return "Data Deleted  Successfully  "   + i ;
	}
	
	@GetMapping("/deleterow/{id}")
	public String DeleteDatainPersonTableById_AfterFindingRow(@PathVariable int id) {
		
		PersonDaoService personDaoService = new PersonDaoService( jdbcTemplate );
		
		PersonEntity personEntity = new PersonEntity();
		
		personEntity = personDaoService.selectARowById( id);
		
		int i =  personDaoService.deletePersonRecord( personEntity );
		
		
		
		return "record " + i + " Deleted  Successfully  "   + personEntity.toString() ;
	}
	
	@GetMapping("/deleterowlambda/{id}")
	public String DeleteDatainPersonTableById_AfterFindingRowWithLambda(@PathVariable int id) {
		PersonDaoService personDaoService=new PersonDaoService( jdbcTemplate );
		PersonEntity personEntity=new PersonEntity();
		personEntity=personDaoService.selectARowById_Lambda( id );
		int i=personDaoService.deletePersonRecord( personEntity );
		return "record " + i + " Deleted  Successfully  "   + personEntity.toString() ;
	}
	
	
	
	@GetMapping("/deleterowrowmapper/{id}")
	public String DeleteDatainPersonTableById_AfterFindingRowWithRowMapper(@PathVariable int id) {
		PersonDaoService personDaoService=new PersonDaoService( jdbcTemplate );
		PersonEntity personEntity=new PersonEntity();
		personEntity=personDaoService.selectARowById_By_RowMappaer( id );
		int i=personDaoService.deletePersonRecord( personEntity );
		return "record " + i + " Deleted  Successfully  "   + personEntity.toString() ;
	}
		
		
		PersonEntity setPersonEntity(PersonEntity personEntity , Person1SqDaoService person1SqDaoService ) {
		
		
		
		int seqId ;
		
		seqId = person1SqDaoService.Person_1sq_get_Next();
		
		
		
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
		
		
		
		jdbcTemplate.execute( "INSERT INTO person " +
				" (id," +
				"email," +
				"name," +
				"password," +
				"role," +
				"created," +
				"enabled) " +
				"VALUES  (" +  person1SqDaoService.Person_1sq_get_Next()  +
				" , 'NarayanSau@gmail.com', " +
				"'Sonali Chndra Sau'," +
				" 'bac123', " +
				"'ADMIN', '" +
				timestamp +
				"' , 1 )") ;
	}
	
}
