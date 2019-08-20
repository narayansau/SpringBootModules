package com.narayan.example.module6springhibernatethymeleafmysqlexample.Repository;

import com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository <Messages, Integer>{


}