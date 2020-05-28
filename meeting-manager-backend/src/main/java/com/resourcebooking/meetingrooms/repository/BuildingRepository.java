package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resourcebooking.meetingrooms.entity.Building;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long>{

}
