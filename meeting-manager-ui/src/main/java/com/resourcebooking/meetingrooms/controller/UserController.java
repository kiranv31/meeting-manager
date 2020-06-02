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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Set<User> listUsers() {
		return service.listAll();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable long id) {
		return service.get(id);
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable long id) {
		User user = service.get(id);
		service.delete(user);
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	public User addUser(User user) {
		return service.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUser(User user, @PathVariable Long id) {
		if(user.getId().equals(id))
			service.update(user);
	}

}
