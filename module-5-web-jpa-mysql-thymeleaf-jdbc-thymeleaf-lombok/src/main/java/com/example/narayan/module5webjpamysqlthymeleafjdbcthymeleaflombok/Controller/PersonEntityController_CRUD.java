package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.Controller;

import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices.PersonDaoService;
import com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices.Sequence1SqDAOImplimentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class PersonEntityController_CRUD{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public PersonEntityController_CRUD(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	
	
	
	
	@GetMapping("/insertcrud")
	public int getNextSequence() {
		
		int seqId;
		
		Sequence1SqDAOImplimentation person1SqDAOImplimentation =
				new Sequence1SqDAOImplimentation(namedParameterJdbcTemplate);
		
		int seqId2 = person1SqDAOImplimentation.GetNextVal( "PERSON_1SQ" );
		int stat = person1SqDAOImplimentation.IncrementNextVal( "PERSON_1SQ" );
		
		return  seqId2   ;
	}
	
	
	@GetMapping("/row/{primaryKey}")
	public PersonEntity selectARowByPrimaryey (@PathVariable Integer primaryKey) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		
		
		return personDaoService.selectARow( primaryKey);
	}
	
	@GetMapping("/rows")
	public List <PersonEntity> selectMultipleRows(PersonEntity row)
	{
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		PersonEntity personEntity = new PersonEntity();
		return personDaoService.selectMultipleRows(personEntity);
		
	}
	
	@GetMapping("/insertr")
	public  int  insertARowa( PersonEntity row) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		
		return personDaoService.insertARow( setPersonEntity(row) );
	}
	
	@GetMapping("/delete/{id}")
	public  int  deleteARowById( @PathVariable Integer id) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		
		return personDaoService.deleteARowById( id );
	}
	
	@GetMapping("/deleter/{id}")
	public  int  deleteARowa( @PathVariable Integer id) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		PersonEntity row =    personDaoService.selectARow( id);
		return personDaoService.deleteARow( row );
	}
	
	@GetMapping("/update/{id}")
	public  int  updateARowa( @PathVariable Integer id) {
		PersonDaoService personDaoService=new PersonDaoService( namedParameterJdbcTemplate);
		PersonEntity row =    personDaoService.selectARow( id);
		return personDaoService.updateARowdata( row );
	}
	
	
	
	
	PersonEntity setPersonEntity(PersonEntity personEntity ) {
		
		int seqId ;
		
		seqId = getNextSequence();
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
