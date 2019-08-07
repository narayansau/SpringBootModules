package com.example.narayan.module3webjdbcmysqllombok.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="person", schema="dbe")
@Data
public class PersonEntity{
    @Id
    private int id;
    private String email;
    private String name;
    private String password;
    private String role;
    private Byte enabled;
    private Timestamp birthdate;
    private Timestamp created;
    private Timestamp modified;
    
}
