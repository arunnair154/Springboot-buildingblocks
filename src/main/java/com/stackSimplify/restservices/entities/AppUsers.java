package com.stackSimplify.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="APPUSERS")
public class AppUsers {
	
	@Id
	@GeneratedValue
	private long userID;
	
	@Column(name="USER_NAME", length = 50, nullable = false, unique = true)
	private String userName;
	
	@Column(name="FIRST_NAME", length = 50)
	private String firstName;
	
	@Column(name="LAST_NAME", length = 50)
	private String lastName;
	
	@Column(name="EMAIL", length = 50)
	private String email;
	
	@Column(name="ROLE", length = 50)
	private String role;
	
	@Column(name="SSN",length = 50, nullable = false, unique = true)
	private String ssn;
	

	public AppUsers() {
		
	}


	public AppUsers(long userID, String userName, String firstName, String lastName, String email, String role,
			String ssn) {
		this.userID = userID;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}
	
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	@Override
	public String toString() {
		return "AppUsers [userID=" + userID + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	

}
