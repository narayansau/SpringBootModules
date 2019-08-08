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
    
    // Constructor
    
   public PersonEntity(int id, String email, String name, String password,
                        String role, Byte enabled, Timestamp birthdate,
                       Timestamp created, Timestamp modified) {
        this.id=id;
        this.email=email;
        this.name=name;
        this.password=password;
        this.role=role;
        this.enabled=enabled;
        this.birthdate=birthdate;
        this.created=created;
        this.modified=modified;
    }
    
    
    public PersonEntity() {
    
    }
}
