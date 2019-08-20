package com.narayan.example.module6springhibernatethymeleafmysqlexample.Repository;

import com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Integer>{
	
	
	 Optional <Users> findByEmail(String email);
}
