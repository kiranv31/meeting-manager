package com.resourcebooking.meetingrooms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Floor extends NamedEntity{
	
	@OneToMany(mappedBy = "floor" , cascade = CascadeType.ALL)
	private Set<MeetingRoom> rooms = new HashSet<>();
	
	@ManyToOne
	private Building building;

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Set<MeetingRoom> getRooms() {
		return rooms;
	}

	public void setRooms(Set<MeetingRoom> rooms) {
		this.rooms = rooms;
	}
	
	public Floor getUpdateCopy(Floor object) {
		if(object.getBuilding() == null)
			object.setBuilding(getBuilding());
		
		if(object.getName() == null)
			object.setName(getName());
		
		if(object.getRooms() == null)
			object.setRooms(getRooms());
		
		return object;

	}
	
}
