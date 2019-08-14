package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.lang.Nullable;


public class Person1SqDaoService1{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	
	public Person1SqDaoService1(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
	}
	
	@Nullable
	public int Person_1sq_get_Next() {
		
		/****************************
		 * // passing parameters
		String sql = "select * from person_1sq  where id > :id ";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
		int seqId  = namedParameterJdbcTemplate.queryForObject(  sql, namedParameters, Integer.class);
		
		***************************/
		
		//Another way
		
		String sql1 = "select * from person_1sq   ";
		
		int seqId  = namedParameterJdbcTemplate.queryForObject(  sql1, new MapSqlParameterSource(),Integer.class );
		
		String query ="update person_1sq set id  = :id" ;
		//namedParameterJdbcTemplate.update(query);
		
		// Adding params using MapSqlParameterSource class
		SqlParameterSource namedParameters = new MapSqlParameterSource().
				addValue("id", seqId + 1);
		
		int status = namedParameterJdbcTemplate.update(query, namedParameters);
		if(status != 0){
			System.out.println("person_1sq data updated for ID " + seqId);
		}else{
			System.out.println("No person_1sq found with ID " + seqId);
		}
		return seqId;
	}
}
