package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;

import com.resourcebooking.meetingrooms.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{

}
