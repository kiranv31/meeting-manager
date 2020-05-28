package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resourcebooking.meetingrooms.entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{

}
