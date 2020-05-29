package com.resourcebooking.meetingrooms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Building extends NamedEntity{
	
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private Set<Floor> floors = new HashSet<>();

	public Set<Floor> getFloors() {
		return floors;
	}

	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}
	
	public Building getUpdateCopy(Building object) {
		if(object.getFloors() == null)
			object.setFloors(getFloors());
		
		if(object.getName() == null)
			object.setName(getName());
		
		return object;
	}
	
}
