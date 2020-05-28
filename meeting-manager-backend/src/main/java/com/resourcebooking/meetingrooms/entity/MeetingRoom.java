package com.resourcebooking.meetingrooms.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MeetingRoom extends NamedEntity{
	
	private int capacity;
	
	private boolean vcEnabled;
	
	private String ipPhoneNumber;
	
	private String email;
	
	@ManyToOne
	private Floor floor;
	
	@OneToOne
	private Booking booking;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isVcEnabled() {
		return vcEnabled;
	}

	public void setVcEnabled(boolean vcEnabled) {
		this.vcEnabled = vcEnabled;
	}

	public String getIpPhoneNumber() {
		return ipPhoneNumber;
	}

	public void setIpPhoneNumber(String ipPhoneNumber) {
		this.ipPhoneNumber = ipPhoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}
