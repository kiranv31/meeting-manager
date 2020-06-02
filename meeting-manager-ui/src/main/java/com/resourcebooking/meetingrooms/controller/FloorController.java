package com.resourcebooking.meetingrooms.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resourcebooking.meetingrooms.entity.Floor;
import com.resourcebooking.meetingrooms.service.FloorService;

@Controller
@RequestMapping(value = "/floor")
public class FloorController {

	private FloorService service;
	
	public FloorController(final FloorService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	public Floor addFloor(Floor floor) {
		return service.save(floor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteFloor(@PathVariable Long id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateFloor(Floor object, @PathVariable Long id) {
		if (id.equals(object.getId())) {
			service.update(object);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Floor getFloor(Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Set<Floor> listFloor() {
		return service.listAll();
	}
}
