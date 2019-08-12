package com.example.narayan.module5webjpamysqlthymeleafjdbcthymeleaflombok.EntityServices;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;


public class Person1SqDaoService1{
	
	private JdbcTemplate jdbcTemplate;
	
	
	
	public Person1SqDaoService1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Nullable
	public int Person_1sq_get_Next() {
		
		//jdbcTemplate = new JdbcTemplate();
		int seqId = jdbcTemplate.queryForObject("select * from person_1sq" , Integer.class);
		
		String query ="update person_1sq set id  = " + (seqId + 1) ;
		jdbcTemplate.update(query);
		
		return seqId;
	}
}
