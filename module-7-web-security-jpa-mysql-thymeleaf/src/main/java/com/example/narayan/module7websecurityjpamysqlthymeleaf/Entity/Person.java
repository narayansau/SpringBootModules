package com.example.narayan.module7websecurityjpamysqlthymeleaf.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Person{
	private Integer id;
	private String email;
	private String name;
	private String password;
	private String role;
	private Byte enabled;
	private Timestamp birthdate;
	private Timestamp created;
	private Timestamp modified;
	
	@Id
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	@Basic
	@Column(name="email", nullable=true, length=50)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	@Basic
	@Column(name="name", nullable=true, length=40)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Basic
	@Column(name="password", nullable=true, length=12)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	@Basic
	@Column(name="role", nullable=true, length=5)
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	
	@Basic
	@Column(name="enabled", nullable=true)
	public Byte getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Byte enabled) {
		this.enabled=enabled;
	}
	
	@Basic
	@Column(name="birthdate", nullable=true)
	public Timestamp getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Timestamp birthdate) {
		this.birthdate=birthdate;
	}
	
	@Basic
	@Column(name="created", nullable=true)
	public Timestamp getCreated() {
		return created;
	}
	
	public void setCreated(Timestamp created) {
		this.created=created;
	}
	
	@Basic
	@Column(name="modified", nullable=true)
	public Timestamp getModified() {
		return modified;
	}
	
	public void setModified(Timestamp modified) {
		this.modified=modified;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person=(Person) o;
		return Objects.equals( id, person.id ) &&
				Objects.equals( email, person.email ) &&
				Objects.equals( name, person.name ) &&
				Objects.equals( password, person.password ) &&
				Objects.equals( role, person.role ) &&
				Objects.equals( enabled, person.enabled ) &&
				Objects.equals( birthdate, person.birthdate ) &&
				Objects.equals( created, person.created ) &&
				Objects.equals( modified, person.modified );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( id, email, name, password, role, enabled, birthdate, created, modified );
	}
}
