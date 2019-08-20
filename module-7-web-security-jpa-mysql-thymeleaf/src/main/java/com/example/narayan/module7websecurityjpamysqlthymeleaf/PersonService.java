package com.example.narayan.module7websecurityjpamysqlthymeleaf;

import com.example.narayan.module7websecurityjpamysqlthymeleaf.Entity.Person;
import com.example.narayan.module7websecurityjpamysqlthymeleaf.ServiceEntities.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@Service
public class PersonService implements PersonServiceInterface{
	//@Autowired
	//private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PersonService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
		
//		this.dataSource = dataSource;
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public void addPerson(String name , Integer id) {
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		Person personEntity = new Person();
		
		personEntity.setId( id );
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		
		cal.add(Calendar.YEAR, -20);
		Timestamp birhDate = new Timestamp(cal.getTime().getTime());
		
		personEntity.setEmail( "Nihgdgdgd@gmail.com" );
		personEntity.setName( name );
		personEntity.setPassword( "jhjhj" );
		personEntity.setRole( "User" );
		personEntity.setEnabled( (byte) 1 );
		
		personEntity.setBirthdate( birhDate  );
		personEntity.setCreated( timestamp );
		personEntity.setModified(  timestamp);
		
		String sql =
		"insert into person values ( "  +
				personEntity.getId()  + ", '"  +
				personEntity.getEmail()  + "', '" +
				personEntity.getName() + "' , '" +
				personEntity.getPassword() + "' ,  '" +
				personEntity.getRole() + "' , " +
				personEntity.getEnabled() + " , '" +
				personEntity.getBirthdate() + "' , '" +
				personEntity.getCreated() + "' , '" +
				personEntity.getModified() + "')" ;
		
		jdbcTemplate.update( sql );
	}
	
	@Override
	public void deletePerson(Integer id) {
	
	}
	
	@Override
	public List allPerson(DateTimeFormatter birthdate) {
		return null;
	}
}
