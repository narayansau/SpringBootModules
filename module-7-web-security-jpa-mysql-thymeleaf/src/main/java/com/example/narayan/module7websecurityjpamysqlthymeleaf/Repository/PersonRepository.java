package com.example.narayan.module7websecurityjpamysqlthymeleaf.Repository;


import com.example.narayan.module7websecurityjpamysqlthymeleaf.Entity.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Integer> {


} ;

