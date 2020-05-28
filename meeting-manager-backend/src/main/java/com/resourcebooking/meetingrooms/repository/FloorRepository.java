package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resourcebooking.meetingrooms.entity.Floor;


@Repository
public interface FloorRepository extends CrudRepository<Floor, Long>{

}
