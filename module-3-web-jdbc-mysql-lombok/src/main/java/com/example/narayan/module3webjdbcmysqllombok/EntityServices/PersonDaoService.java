package com.example.narayan.module3webjdbcmysqllombok.EntityServices;

import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import org.springframework.jdbc.core.JdbcTemplate;


public class PersonDaoService{
	
	private JdbcTemplate jdbcTemplate;
	//Person1SqDaoService person1Sq;
	
	
	
	public PersonDaoService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public void savePersonWith_execute_Command(PersonEntity e) {
		
		String query = Cretate_Query ( e );
	
		  jdbcTemplate.execute( query );
	}
	
	public int  savePersonWith_update_Command(PersonEntity e) {
		
		String query = Cretate_Query ( e );
		
		return jdbcTemplate.update( query );
		
	}
	
	public int updatePerson(PersonEntity e) {
		String query = "update person set " +
				"name = " + e.getName() + " where id = " +
				e.getId() + " ";
		
		return jdbcTemplate.update(query);
		
	}
	
	public int deletePerson(PersonEntity e) {
		String query = "delete  person  " +
				 " where id = " +
				e.getId() + " ";
		
		return jdbcTemplate.update(query);
		
	}
	
	private String Cretate_Query (PersonEntity e ){
		
		return
				"insert into person values ( "  +
						e.getId()  + ", '"  +
						e.getEmail()  + "', '" +
						e.getName() + "' , '" +
						e.getPassword() + "' ,  '" +
						e.getRole() + "' , " +
						e.getEnabled() + " , '" +
						e.getBirthdate() + "' , '" +
						e.getCreated() + "' , '" +
						e.getModified() + "')" ;
	}
	
	
}
