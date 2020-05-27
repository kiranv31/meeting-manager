package com.resourcebooking.meetingrooms.entity;

import javax.persistence.Enumerated;

public class User extends NamedEntity {
	
	@Enumerated
	private UserRole userRole;
	private String emailId;
	private String phone;

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
