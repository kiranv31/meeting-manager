package com.resourcebooking.meetingrooms.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.resourcebooking.meetingrooms.entity.Building;
import com.resourcebooking.meetingrooms.entity.Floor;
import com.resourcebooking.meetingrooms.service.BuildingService;
import com.resourcebooking.meetingrooms.service.FloorService;

@Controller
@RequestMapping(value = "/building")
public class BuildingController {

	private BuildingService service;
	private FloorService fservice;

	public BuildingController(final BuildingService service, FloorService fservice) {
		this.service = service;
		this.fservice = fservice;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	public Building addBuilding(Building building) {
		return service.save(building);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteBuilding(@PathVariable Long id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateBuilding(Building object, @PathVariable Long id) {
		if (id.equals(object.getId())) {
			service.update(object);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Building getBuilding(Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Set<Building> listBuildings() {
		return service.listAll();
	}
	
	@RequestMapping(value = "/{id}/floor", method = RequestMethod.PUT)
	@ResponseBody
	public Building addFllor(Floor floor, @PathVariable long id) {
		Building existingB = service.get(id);
		if(existingB.getId() == null)
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Building Not Found");
		Floor existingF = fservice.get(id);
		
		if(existingF.getId() == null) 
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Floor Not Found");
		
		existingB.getFloors().add(existingF);
		return service.save(existingB);	
	}
	
	
}
