package com.example.narayan.module2webjpaapachederbywiththymeleaf.Entity_Repository;

import com.example.narayan.module2webjpaapachederbywiththymeleaf.Enitity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserEntity, String>{
}