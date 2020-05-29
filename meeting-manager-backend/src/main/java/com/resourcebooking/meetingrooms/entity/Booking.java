package com.resourcebooking.meetingrooms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Booking extends BaseEntity {
	
	@ManyToOne
	private User owner;
	
	@ManyToOne
	private MeetingRoom meetingRoom;
	
	private LocalDateTime start;
	private LocalDateTime end;
	private String bookingPurpose;
	
	@Enumerated(EnumType.STRING)
	private BookingType bookingType;
	
	@Enumerated(EnumType.STRING)
	private RecursiveBookingType reccurBookingType;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStaus;
	
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

	public BookingType getBookingType() {
		return bookingType;
	}

	public void setBookingType(BookingType bookingType) {
		this.bookingType = bookingType;
	}

	public RecursiveBookingType getReccurBookingType() {
		return reccurBookingType;
	}

	public void setReccurBookingType(RecursiveBookingType reccurBookingType) {
		this.reccurBookingType = reccurBookingType;
	}

	public BookingStatus getBookingStaus() {
		return bookingStaus;
	}

	public void setBookingStaus(BookingStatus bookingStaus) {
		this.bookingStaus = bookingStaus;
	}
	
}
