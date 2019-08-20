package com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Roles{
	private Integer id;
	private String name;
	private Collection <UserRoles> userRolesById;
	
	@Id
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	@Basic
	@Column(name="name", nullable=true, length=45)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Roles roles=(Roles) o;
		return Objects.equals( id, roles.id ) &&
				Objects.equals( name, roles.name );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( id, name );
	}
	
	@OneToMany(mappedBy="rolesByRoleId")
	public Collection <UserRoles> getUserRolesById() {
		return userRolesById;
	}
	@ManyToMany(mappedBy = "roles")
	private List < Users > users;
	
	public void setUserRolesById(Collection <UserRoles> userRolesById) {
		this.userRolesById=userRolesById;
	}
	
	public List < Users > getUsers() {
		return users;
	}
	
	public void setUsers(List < Users > users) {
		this.users = users;
	}
}
