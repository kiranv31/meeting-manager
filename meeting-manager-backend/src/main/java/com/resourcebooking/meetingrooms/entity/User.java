package com.resourcebooking.meetingrooms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class User extends NamedEntity {
	
	@Enumerated(EnumType.STRING)
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

	public User getUpadteCopy(User object) {
		if(object.getName() == null) {
			object.setName(getName());
		}
		if(object.getEmailId() == null) {
			object.setEmailId(getEmailId());
		}
		if(object.getPhone() == null) {
			object.setPhone(getPhone());
		}
		if(object.getUserRole() == null) {
			object.setUserRole(getUserRole());
		}
		return object;
	}
}
