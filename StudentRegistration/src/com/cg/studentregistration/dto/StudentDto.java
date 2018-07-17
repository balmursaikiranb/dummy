package com.cg.studentregistration.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class StudentDto implements Serializable{

	private  String sName;
	private long sPhone;
	private String email;
	private int age;
	private String gender;
	private String sCity;
	private String status;
	private LocalDate date;
	private String college;
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public long getsPhone() {
		return sPhone;
	}
	public void setsPhone(long sPhone) {
		this.sPhone = sPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
