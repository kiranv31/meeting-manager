package com.resourcebooking.meetingrooms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MeetingRoom extends NamedEntity{
	
	private int capacity;
	
	private boolean vcEnabled;
	
	private String ipPhoneNumber;
	
	private String email;
	
	@ManyToOne
	private Floor floor;
	
	@OneToMany(mappedBy = "meetingRoom", cascade = CascadeType.ALL)
	private Set<Booking> booking = new HashSet<>();

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

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	
	public MeetingRoom getUpdateCopy(MeetingRoom object) {
		if(object.getBooking() == null)
			object.setBooking(getBooking());
		
		if(object.getCapacity() == 0) 
			object.setCapacity(getCapacity());
		
		if(object.getEmail() == null)
			object.setEmail(getEmail());
		
		if(object.getFloor() == null)
			object.setFloor(getFloor());
		
		if(object.getIpPhoneNumber() == null){
			object.setIpPhoneNumber(getIpPhoneNumber());
			
		if(object.getName() == null)
			object.setName(getName());
		}
		return object;
	}
}
