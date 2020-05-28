package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resourcebooking.meetingrooms.entity.MeetingRoom;

@Repository
public interface MeetingRoomRepository extends CrudRepository<MeetingRoom, Long>{

}
