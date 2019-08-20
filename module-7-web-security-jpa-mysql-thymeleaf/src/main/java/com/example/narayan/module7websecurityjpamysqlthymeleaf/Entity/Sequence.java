package com.example.narayan.module7websecurityjpamysqlthymeleaf.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Sequence{
	private String personSeq;
	private Integer sqNextval;
	
	@Id
	@Column(name="PERSON_SEQ", nullable=false, length=20)
	public String getPersonSeq() {
		return personSeq;
	}
	
	public void setPersonSeq(String personSeq) {
		this.personSeq=personSeq;
	}
	
	@Basic
	@Column(name="SQ_NEXTVAL", nullable=false)
	public Integer getSqNextval() {
		return sqNextval;
	}
	
	public void setSqNextval(Integer sqNextval) {
		this.sqNextval=sqNextval;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sequence sequence=(Sequence) o;
		return Objects.equals( personSeq, sequence.personSeq ) &&
				Objects.equals( sqNextval, sequence.sqNextval );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( personSeq, sqNextval );
	}
}
