package com.example.narayan.module3webjdbcmysqllombok.Repositories;

import com.example.narayan.module3webjdbcmysqllombok.Entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, String >{
}
