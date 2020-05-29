package com.resourcebooking.meetingrooms.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resourcebooking.meetingrooms.entity.User;
import com.resourcebooking.meetingrooms.service.BaseService;
import com.resourcebooking.meetingrooms.service.UserService;

@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	private UserService service;
	
	public UserController(final UserService service){
		this.service = service;
	}
	
	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	@ResponseBody
	public Set<User> listUsers() {
		return service.listAll();
	}	
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable long id) {
		return service.get(id);
	}	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable long id) {
		User user = service.get(id);
		service.delete(user);
	}
	
	@RequestMapping(value = "/add/new", method = RequestMethod.POST)
	@ResponseBody
	public User addUser(User user) {
		return service.save(user);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUser(User user) {
		service.update(user);
	}

}
