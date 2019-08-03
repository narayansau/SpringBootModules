package com.example.narayan.module3webjdbcmysqllombok.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PersonEntityController{
	
	@Autowired
	JdbcTemplate  jdbcTemplate;
	
	
	@RequestMapping("/insert")
public String index() {
		jdbcTemplate.execute( "INSERT INTO person " +
				" (id," +
				"email," +
				"name," +
				"password," +
				"role," +
				"enabled) " +
				
				"VALUES " +
				"(1002, 'NarayanSau@gmail.com', " +
				"'Narayan Chndra Sau'," +
				" 'bac123', " +
				"'ADMIN'," +
				" 1 )") ;
		return "Data Inserted Successfully";
	}
}
