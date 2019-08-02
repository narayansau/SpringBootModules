package com.example.narayan.module2webjpaapachederbywiththymeleaf.Entity_Service;

import com.example.narayan.module2webjpaapachederbywiththymeleaf.Enitity.UserEntity;
import com.example.narayan.module2webjpaapachederbywiththymeleaf.Entity_Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/************************************************************
 *  1.  Select * from  UserEntity  table/ entity
 *  2. Select a row / null  from  UserEntity  table/ entity identified by @ID
 *  3. Insert a row in  UserEntity  table/ entity
 *  4. Delete  a row / null  from  UserEntity  table/ entity identified by @ID
 ***************************************************************************/

@Service
public class UserService{
	
	
	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public List<UserEntity>  selectAllUsers ()  {
		List<UserEntity> userEntityList = new ArrayList <>( );
		 userRepository.findAll().forEach( userEntityList :: add );
		 return userEntityList;
	}
	
	public Optional<UserEntity> getAsingleUserBy_PK (String id) {
		return  userRepository.findById( id );
	}
	
	public void insertOrUpdate_A_UserEntityRecord(UserEntity userEntity){
		userRepository.save( userEntity );
		
	}
	
	public void delete_A_UserEntityRecord_by_PK(String id){
		userRepository.deleteById( id );
	}

}
