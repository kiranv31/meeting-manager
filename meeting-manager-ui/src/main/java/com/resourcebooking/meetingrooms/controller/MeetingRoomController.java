package com.resourcebooking.meetingrooms.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resourcebooking.meetingrooms.entity.MeetingRoom;
import com.resourcebooking.meetingrooms.service.MeetingRoomService;

@Controller
@RequestMapping(value = "/room")
public class MeetingRoomController {

	private MeetingRoomService service;
	
	public MeetingRoomController(final MeetingRoomService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	public MeetingRoom addMeetingRoom(MeetingRoom floor) {
		return service.save(floor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteMeetingRoom(@PathVariable Long id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateMeetingRoom(MeetingRoom object, @PathVariable Long id) {
		if (id.equals(object.getId())) {
			service.update(object);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MeetingRoom getMeetingRoom(Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Set<MeetingRoom> listMeetingRooms() {
		return service.listAll();
	}
}
