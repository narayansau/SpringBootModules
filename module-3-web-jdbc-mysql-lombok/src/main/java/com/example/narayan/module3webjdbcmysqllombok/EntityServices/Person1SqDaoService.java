package com.example.narayan.module3webjdbcmysqllombok.EntityServices;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;


public class Person1SqDaoService{
	
	private JdbcTemplate jdbcTemplate;
	
	public Person1SqDaoService(JdbcTemplate jdbcTemplate) {
	          this.jdbcTemplate=jdbcTemplate;
	}
	
	@Nullable
	public int Person_1sq_get_Next() {
		int seqId = jdbcTemplate.queryForObject("select * from person_1sq" , Integer.class);
		
		String query ="update person_1sq set id  = " + (seqId + 1) ;
		jdbcTemplate.update(query);
		
		return seqId;
	}
}
