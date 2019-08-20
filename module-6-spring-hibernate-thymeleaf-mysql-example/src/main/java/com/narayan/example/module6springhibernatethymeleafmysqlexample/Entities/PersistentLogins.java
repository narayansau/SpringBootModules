package com.narayan.example.module6springhibernatethymeleafmysqlexample.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="persistent_logins", schema="dbe", catalog="")
public class PersistentLogins{
	private String username;
	private String series;
	private String token;
	private Timestamp lastUsed;
	
	@Basic
	@Column(name="username", nullable=false, length=64)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	@Id
	@Column(name="series", nullable=false, length=64)
	public String getSeries() {
		return series;
	}
	
	public void setSeries(String series) {
		this.series=series;
	}
	
	@Basic
	@Column(name="token", nullable=false, length=64)
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token=token;
	}
	
	@Basic
	@Column(name="last_used", nullable=false)
	public Timestamp getLastUsed() {
		return lastUsed;
	}
	
	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed=lastUsed;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PersistentLogins that=(PersistentLogins) o;
		return Objects.equals( username, that.username ) &&
				Objects.equals( series, that.series ) &&
				Objects.equals( token, that.token ) &&
				Objects.equals( lastUsed, that.lastUsed );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( username, series, token, lastUsed );
	}
}
