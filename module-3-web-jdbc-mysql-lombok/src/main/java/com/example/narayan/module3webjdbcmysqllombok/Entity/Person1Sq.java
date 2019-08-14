package com.example.narayan.module3webjdbcmysqllombok.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="person_1sq", schema="dbe")
@Data
public class Person1Sq{
	@Id
	private int id;
	
	public Person1Sq(int id) {
		this.id=id;
	}
	
	public Person1Sq(int id, String person_seq) {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
}
