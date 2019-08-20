package com.example.narayan.module7websecurityjpamysqlthymeleaf.ServiceEntities;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface PersonServiceInterface{
	
	void addPerson(String name , Integer id);
	void deletePerson(Integer id);
	List allPerson(DateTimeFormatter birthdate);
	
}
