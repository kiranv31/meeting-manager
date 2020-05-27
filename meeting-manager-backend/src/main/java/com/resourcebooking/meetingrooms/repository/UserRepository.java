package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;

import com.resourcebooking.meetingrooms.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
