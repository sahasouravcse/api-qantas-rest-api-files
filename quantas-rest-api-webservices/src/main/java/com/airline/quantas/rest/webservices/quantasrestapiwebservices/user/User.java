package com.airline.quantas.rest.webservices.quantasrestapiwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message="Name should have atleast 2 characters")
	private String name;
	@Past
	private Date birthDate;
	private String home_address;
	private String email_address;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, Date birthDate, String home_address,String email_address) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.home_address=home_address;
		this.email_address=email_address;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", home_address=" + home_address
				+ ", email_address=" + email_address + "]";
	}


	

}
