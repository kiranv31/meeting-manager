package com.resourcebooking.meetingrooms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resourcebooking.meetingrooms.entity.User;

@RequestMapping({"/user"})
@Controller
public class UserController {
	
	@RequestMapping(value = "/list")
	public String listUsers() {
		return null;
	}	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getUser(long id) {
		return null;
	}	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteUser(long id) {
		return null;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String deleteUser(User user) {
		return null;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public String deleteUser(User user, long id) {
		return null;
	}
}
