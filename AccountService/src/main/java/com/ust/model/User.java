package com.ust.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	@NotNull
	private String firstName;
	@NotNull
	private String middleName;
	@NotNull
	private String lastName;
	@NotNull
	private int age;
	private LocalDate createDate;
	private LocalDate updateDate;
	
	
	public User() {
		super();
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}


	public User(String firstName, String middleName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}


	public int getAccountId() {
		return accountId;
	}


//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public LocalDate getCreateDate() {
		return createDate;
	}


//	public void setCreateDate(LocalDate createDate) {
//		this.createDate = createDate;
//	}


	public LocalDate getUpdateDate() {
		return updateDate;
	}


//	public void setUpdateDate(LocalDate updateDate) {
//		this.updateDate = updateDate;
//	}
	
	
	
	
}
