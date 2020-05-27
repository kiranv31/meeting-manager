package com.resourcebooking.meetingrooms.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Booking extends BaseEntity {
	private LocalDateTime start;
	private LocalDateTime end;
	private String bookingPurpose;
	private Set<User> attendee = new HashSet<>();

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

	public Set<User> getAttendee() {
		return attendee;
	}

	public void setAttendee(Set<User> attendee) {
		this.attendee = attendee;
	}

}
