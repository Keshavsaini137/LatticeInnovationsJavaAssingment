package com.star.paitentRegistration.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.star.paitentRegistration.validation.PasswordRules;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="is require")
	@Size(min=3, message="should be more then 3")
	@Column(name="name")
	private String name;
	
	@NotNull(message="is require")
	@Size(min=10, message="should be more then 3")
	@Column(name="address")
	private String address;
	
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull(message="is require")
	@Size(min=10, message="should be more then 3")
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@PasswordRules
	@Column(name="password")
	private String password;
	
	
	Patient(){
		
	}

	public Patient(String name, String address, String email, String phoneNumber, Date date, String password) {
		//super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.password = password;
	}
	
	
	public Date getDate() {
		return date;
	}
	
	public void setDate() {
		this.date = new Date();
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + "]";
	}
	
	
	
}












