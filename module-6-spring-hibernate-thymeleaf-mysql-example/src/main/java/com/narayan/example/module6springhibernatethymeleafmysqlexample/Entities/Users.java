package com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Users{
	private Integer id;
	private String name;
	
	@Email(message="{errors.invalid_email}")
	private String email;
	
	@Size(min=4)
	private String password;
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
	
	@Basic
	@Column(name="email", nullable=true, length=45)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	@Basic
	@Column(name="password", nullable=true, length=45)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
			name="user_roles",
			joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List <Roles> roles;
	
	public List<Roles> getRoles()
	{
		return roles;
	}
	public void setRoles(List<Roles> roles)
	{
		this.roles = roles;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Users users=(Users) o;
		return Objects.equals( id, users.id ) &&
				Objects.equals( name, users.name ) &&
				Objects.equals( email, users.email ) &&
				Objects.equals( password, users.password );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( id, name, email, password );
	}
	
	@OneToMany(mappedBy="usersByUserId")
	public Collection <UserRoles> getUserRolesById() {
		return userRolesById;
	}
	
	public void setUserRolesById(Collection <UserRoles> userRolesById) {
		this.userRolesById=userRolesById;
	}
}
