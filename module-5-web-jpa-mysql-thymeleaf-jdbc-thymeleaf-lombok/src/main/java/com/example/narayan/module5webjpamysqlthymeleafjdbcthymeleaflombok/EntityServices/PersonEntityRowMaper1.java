package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices;

import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class PersonEntityRowMaper1 implements RowMapper <PersonEntity>{
	
	@Override
	public PersonEntity mapRow(ResultSet  rs , int rowNum) throws SQLException {
		PersonEntity personEntity = new PersonEntity();
				personEntity.setId(rs.getInt("id"));
				personEntity.setEmail( rs.getString("email"));
				//personEntity.setName( rs.getString("name"));
		//  Example use of column ny=umber instead of column name
				personEntity.setName( rs.getString(3));
				personEntity.setPassword(   rs.getString("password"));
				personEntity.setRole(  rs.getString("role"));
				personEntity.setEnabled( (byte)  rs.getByte("enabled"));
				personEntity.setBirthdate(  rs.getTimestamp("birthdate")) ;
				personEntity.setCreated(  rs.getTimestamp("created") );
				personEntity.setModified(  rs.getTimestamp("modified")) ;
		      return  personEntity;
	}
	
	
}
