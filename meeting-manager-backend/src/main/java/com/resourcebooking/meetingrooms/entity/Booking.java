package com.resourcebooking.meetingrooms.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Booking extends BaseEntity {
	
	@ManyToOne
	private User owner;
	
	@OneToOne(mappedBy = "booking")
	private MeetingRoom meetingRoom;
	
	private LocalDateTime start;
	private LocalDateTime end;
	private String bookingPurpose;
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}


	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public String getBookingPurpose() {
		return bookingPurpose;
	}

	public void setBookingPurpose(String bookingPurpose) {
		this.bookingPurpose = bookingPurpose;
	}

}
