package com.resourcebooking.meetingrooms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resourcebooking.meetingrooms.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
