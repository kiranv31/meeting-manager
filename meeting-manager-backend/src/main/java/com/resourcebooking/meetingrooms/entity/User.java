package com.resourcebooking.meetingrooms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class User extends NamedEntity {
	
	@Enumerated
	private UserRole userRole;
	private String emailId;
	private String phone;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Booking> booking = new HashSet<>();

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
