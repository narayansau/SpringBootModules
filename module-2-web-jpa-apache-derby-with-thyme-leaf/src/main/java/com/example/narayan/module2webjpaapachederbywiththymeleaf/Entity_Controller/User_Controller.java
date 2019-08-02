package com.example.narayan.module2webjpaapachederbywiththymeleaf.Entity_Controller;


import com.example.narayan.module2webjpaapachederbywiththymeleaf.Enitity.UserEntity;
import com.example.narayan.module2webjpaapachederbywiththymeleaf.Entity_Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/************************************************************
 * User_Controller is mapping the UserServices to frontEnd http://localhosts
 *  1.  Select * from  UserEntity  table/ entity
 *  2. Select a row / null  from  UserEntity  table/ entity identified by @ID
 *  3. Insert a row in  UserEntity  table/ entity
 *  4. Delete  a row / null  from  UserEntity  table/ entity identified by @ID
 ***************************************************************************/

@RestController
public class User_Controller{

	private UserService userService;
	
	@Autowired
public User_Controller(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/")
	public List<UserEntity> selectAllUsers() {
		return userService.selectAllUsers();
	}
	
	@PostMapping("/add-user")
	public  void  insertOrUpdate_A_UserEntityRecord(@RequestBody UserEntity userEntity) {
	      userService.insertOrUpdate_A_UserEntityRecord( userEntity );
	}
	
	@GetMapping("/user/{id}")
	public Optional <UserEntity> getAsingleUserBy_PK (@PathVariable String id) {
		return  userService.getAsingleUserBy_PK( id );
	}
	
	@DeleteMapping("/users/{id}")
	public void delete_A_UserEntityRecord_by_PK(@PathVariable String id) {
		userService.delete_A_UserEntityRecord_by_PK( id );
	}
}
