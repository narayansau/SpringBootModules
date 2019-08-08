package com.example.narayan.module3webjdbcmysqllombok.EntityServices;

import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class PersonDaoService{
	
	private JdbcTemplate jdbcTemplate;
	
	public PersonDaoService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public void savePersonWith_execute_Command(PersonEntity e) {
		
		String query = Cretate_Query ( e );
	
		  jdbcTemplate.execute( query );
	}
	
	
	/*******************************************************
	 *
	 * @param e
	 * @return int
	 * is used to insert, update and delete records using PreparedStatement using given arguments.
	 ***********************************************************************/
	public int  savePersonWith_update_Command(PersonEntity e) {
		
		String query = Cretate_Query ( e  );
		
		return jdbcTemplate.update( query );
		
	}
	
	public int updatePerson(PersonEntity e) {
		String query = "update person set " +
				"name = " + e.getName() + " where id = " +
				e.getId() + " ";
		
		return jdbcTemplate.update(query);
		
	}
	
	public int deletePersonWithId(int e) {
		String query = "delete  from person  " +
				 " where id = " + e + " ";
		
		return jdbcTemplate.update(query);
		
	}
	
	public int deletePersonRecord(PersonEntity e) throws DataAccessException{
		String query="delete from person where id='"+e.getId()+"' ";
		return jdbcTemplate.update(query);
	}
	
	
	public  PersonEntity selectARowById (int e) throws DataAccessException {
		String sql = "SELECT * FROM person WHERE ID =  ? " ;
		
		PersonEntity  personEntity = jdbcTemplate.queryForObject ( sql,
				  new Object []{e} ,
				new BeanPropertyRowMapper<PersonEntity> (PersonEntity.class) );
				
		return  personEntity;
	}
	
	//Select a rowid by using Lambda function
	public PersonEntity selectARowById_Lambda (int e) throws DataAccessException {
		
		String sql = "SELECT * FROM person WHERE ID =  ? " ;
		
		// Lambda function  (rs, rowNum) ->  is equivalent to BeanPropertyRowMapper
		return jdbcTemplate.queryForObject(sql, new Object[]{e}, (rs, rowNum) ->
				new PersonEntity(
						rs.getInt("id"),
						rs.getString("email"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getString("role"),
						rs.getByte("enabled"),
						rs.getTimestamp("birthdate") ,
						rs.getTimestamp("created") ,
						rs.getTimestamp("modified")
				));
		
	}
	

	
	//Select a rowid by using Lambda function
	public PersonEntity selectARowById_By_RowMappaer (int e)  throws DataAccessException {
		
		String sql="SELECT * FROM person WHERE ID =  ? ";
		
		// Lambda function  (rs, rowNum) ->  is equivalent to BeanPropertyRowMapper
		return jdbcTemplate.queryForObject( sql, new Object[]{e}, new PersonEntityRowMaper() );
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
