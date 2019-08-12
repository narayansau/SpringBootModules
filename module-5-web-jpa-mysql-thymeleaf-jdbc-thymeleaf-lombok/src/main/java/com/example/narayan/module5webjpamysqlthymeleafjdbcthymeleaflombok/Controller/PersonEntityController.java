package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Controller;


import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices.Person1SqDaoService1;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices.PersonDaoService;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonEntityController{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public PersonEntityController(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}

	@GetMapping("/insert")
	public String variousInsertofDatainPersonTable() {
		
		int seqId;
		
		/**********************
		 * // Entity Dao Services
		 * Genereally need to define all Entity DAo service and
		 * All Entity , and initialize them.
		 * If an Entity object does noy need any input data m that entity may not require to initialize here
		 **************************/
		
		
		Person1SqDaoService1 person1SqDaoService1=new Person1SqDaoService1( namedParameterJdbcTemplate );
		
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate );
		PersonEntity personEntity=new PersonEntity();
		
		seqId = person1SqDaoService1.Person_1sq_get_Next();
		
		return "Got the sequence"  + seqId   +  namedParameterJdbcTemplate.getJdbcTemplate() + "  " +
				    namedParameterJdbcTemplate.getJdbcOperations();
	}
}
/*
	// Premitive type insert into a table
	
	personDaoService.insert_locally_with_execute ( person1SqDaoService1 );
	
	
	/*******************************
	 *  Want to insert row in a table
	 *  Set values of all required column of the entity
	 *  Call DaoService of those entities.
	 **********************************
	personEntity = setPersonEntity( personEntity , person1SqDaoService1 );
		
		// Insert can be done by  executing DDL query.  with void reurn type
		personDaoService.savePersonWith_execute_Command(personEntity   );
	
	personEntity = setPersonEntity( personEntity , person1SqDaoService1 );
	
	
	// Insert can be done by  executing update query.  with  return type Integer
	// insert, update and delete records  can be done with this query
	//  return 1 is success.
	
	    int i = personDaoService.savePersonWith_update_Command(personEntity);
		
	
		return "Data Inserted Successfully  " + i;
	}

	
	
	
	@GetMapping("/delete/{id}")
	public String DeleteDatainPersonTableById(@PathVariable int id) {
		
		PersonDaoService personDaoService = new PersonDaoService( namedParameterJdbcTemplate);
		
		
		
		int i = personDaoService.deletePersonWithId(id)  ;
		
		return "Data Deleted  Successfully  "   + i ;
	}
	
	@GetMapping("/deleterow/{id}")
	public String DeleteDatainPersonTableById_AfterFindingRow(@PathVariable int id) {
		
		PersonDaoService personDaoService = new PersonDaoService(namedParameterJdbcTemplate );
		
		PersonEntity personEntity = new PersonEntity();
		
		personEntity = personDaoService.selectARowById( id);
		
		int i =  personDaoService.deletePersonRecord( personEntity );
		
		
		
		return "record " + i + " Deleted  Successfully  "   + personEntity.toString() ;
	}
	
	@GetMapping("/deleterowlambda/{id}")
	public String DeleteDatainPersonTableById_AfterFindingRowWithLambda(@PathVariable int id) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		PersonEntity personEntity=new PersonEntity();
		personEntity=personDaoService.selectARowById_Lambda( id );
		int i=personDaoService.deletePersonRecord( personEntity );
		return "record " + i + " Deleted  Successfully  "   + personEntity.toString() ;
	}
	
	
	
	@GetMapping("/deleterowrowmapper/{id}")
	public String DeleteDatainPersonTableById_AfterFindingRowWithRowMapper(@PathVariable int id) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		PersonEntity personEntity=new PersonEntity();
		personEntity=personDaoService.selectARowById_By_RowMappaer( id );
		int i=personDaoService.deletePersonRecord( personEntity );
		return "record " + i + " Deleted  Successfully  "   + personEntity.toString() ;
	}
		@GetMapping("/all")
		public List <PersonEntity> DisplayAllRows () {
			PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		
		//return  personDaoService.findAll();
					//return personDaoService.getAllEmployeesRowMapper();
			
			//return personDaoService.selectAllRowBy_By_RowMappaer();
			return personDaoService.findAllAsQueryForList();
		}
		
		PersonEntity setPersonEntity(PersonEntity personEntity , Person1SqDaoService1 person1SqDaoService1) {
		
		
		
		int seqId ;
		
		seqId = person1SqDaoService1.Person_1sq_get_Next();
		
		
		
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
	
	
	
}

*/