package com.company.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class StudentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	private int sId;
	private String sName;
	@NotBlank
	private String sSubject;

	
	
	

	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsSubject() {
		return sSubject;
	}
	public void setsSubject(String sSubject) {
		this.sSubject = sSubject;
	}
	@Override
	public String toString() {
		return "StudentRequest [sId=" + sId + ", sName=" + sName + ", sSubject=" + sSubject + "]";
	}
	
	
}
