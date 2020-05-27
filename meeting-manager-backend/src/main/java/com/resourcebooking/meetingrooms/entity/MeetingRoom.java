package com.resourcebooking.meetingrooms.entity;


public class MeetingRoom extends NamedEntity{
	
	private int capacity;
	
	private boolean vcEnabled;
	
	private String ipPhoneNumber;
	
	private String email;

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
	
}
