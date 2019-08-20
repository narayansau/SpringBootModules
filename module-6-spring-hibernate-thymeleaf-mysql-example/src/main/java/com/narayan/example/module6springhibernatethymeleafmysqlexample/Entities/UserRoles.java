package com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities;

import javax.persistence.*;

@Entity
@Table(name="user_roles", schema="dbe", catalog="")
public class UserRoles{
	private String id;
	private Users usersByUserId;
	private Roles rolesByRoleId;
	
	@Id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id", nullable=false)
	public Users getUsersByUserId() {
		return usersByUserId;
	}
	
	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId=usersByUserId;
	}
	
	@ManyToOne
	@JoinColumn(name="role_id", referencedColumnName="id", nullable=false)
	public Roles getRolesByRoleId() {
		return rolesByRoleId;
	}
	
	public void setRolesByRoleId(Roles rolesByRoleId) {
		this.rolesByRoleId=rolesByRoleId;
	}
}
