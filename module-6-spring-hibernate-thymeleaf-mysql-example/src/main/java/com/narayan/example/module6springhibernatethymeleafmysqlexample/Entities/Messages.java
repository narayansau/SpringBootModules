package com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Messages{
	private Integer id;
	private String content;
	
	@Id
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	@Basic
	@Column(name="content", nullable=false, length=45)
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content=content;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Messages messages=(Messages) o;
		return Objects.equals( id, messages.id ) &&
				Objects.equals( content, messages.content );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( id, content );
	}
}
