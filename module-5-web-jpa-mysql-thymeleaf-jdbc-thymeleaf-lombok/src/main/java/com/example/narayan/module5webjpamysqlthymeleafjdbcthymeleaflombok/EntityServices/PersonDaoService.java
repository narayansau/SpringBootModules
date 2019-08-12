package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices;

import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
		return jdbcTemplate.queryForObject( sql, new Object[]{e}, new PersonEntityRowMaper1() {
			@Override
			public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				return super.mapRow( rs, rowNum );
			}
		} );
	}
	
	// Select Multiple rows
	
	
	public List <PersonEntity> findAll() {
		
		String sql = "SELECT * FROM person";
		
		List<PersonEntity> personEntityList = jdbcTemplate.query(
				sql,
				new BeanPropertyRowMapper(PersonEntity.class));
		
		return personEntityList;
	}
	
	
	public List<PersonEntity> getAllEmployeesRowMapper(){
		return jdbcTemplate.query("select * from person",new   PersonEntityRowMaper1(){
			@Override
			public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				return super.mapRow( rs, rowNum );
			}
		});};
	
	//Select all rows by using Lambda function
	public List <PersonEntity> selectAllRowBy_By_RowMappaer ()  throws DataAccessException {
		
		String sql="SELECT * FROM person ";
		
		// Lambda function  (rs, rowNum) ->  is equivalent to BeanPropertyRowMapper
		return jdbcTemplate.query(sql,  (rs, rowNum) ->
				new PersonEntity(
						rs.getInt("id"),
						rs.getString("email"),
						rs.getString(3),          // Using Column number instead of column name
						rs.getString("password"),
						rs.getString("role"),
						rs.getByte("enabled"),
						rs.getTimestamp("birthdate") ,
						rs.getTimestamp("created") ,
						rs.getTimestamp("modified")
				));
	}
	
	// Find all rows as list with mao
	
	public List<PersonEntity> findAllAsQueryForList() {
		
		String sql = "SELECT * FROM person";
		
		List<PersonEntity> allPersons = new ArrayList <>();
		
		List<Map <String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		for (Map rs : rows) {
			PersonEntity obj = new PersonEntity();
			
			obj.setId(((Integer) rs.get("Id")).intValue());
			obj.setEmail(( String) rs.get("email"));
			
			
			obj.setName( (String) rs.get(3));
			obj.setPassword( (String)  rs.get("password"));
			obj.setRole( ( String) rs.get("role"));
		//	obj.setEnabled( ( (Byte)   rs.get("enabled")).());
			obj.setBirthdate(  (Timestamp) rs.get("birthdate")) ;
			obj.setCreated( (Timestamp)   rs.get("created") );
			obj.setModified(  (Timestamp)  rs.get("modified")) ;
			allPersons.add(obj);
		}
		
		return allPersons;
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
	

	public void  insert_locally_with_execute (  Person1SqDaoService1 person1SqDaoService1 ) {
		//jdbcTemplate = new JdbcTemplate();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		 person1SqDaoService1 = new Person1SqDaoService1(jdbcTemplate);
		
		
		jdbcTemplate.execute( "INSERT INTO person " +
				" (id," +
				"email," +
				"name," +
				"password," +
				"role," +
				"created," +
				"enabled) " +
				"VALUES  (" +  person1SqDaoService1.Person_1sq_get_Next()  +
				" , 'NarayanSau@gmail.com', " +
				"'Sonali Chndra Sau'," +
				" 'bac123', " +
				"'ADMIN', '" +
				timestamp +
				"' , 1 )") ;
	}
	
}
