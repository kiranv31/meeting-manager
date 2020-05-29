package com.resourcebooking.meetingrooms.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import com.resourcebooking.meetingrooms.entity.Building;
import com.resourcebooking.meetingrooms.repository.BuildingRepository;

public class BuildingService implements BaseService<Building, Long>{

	private BuildingRepository repo;
	
	public BuildingService(BuildingRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Building save(Building object) {
		return repo.save(object);
	}

	@Override
	public void delete(Building object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Building get(Long id) {
		Optional<Building> existing = repo.findById(id);
		return existing.orElseGet(()-> new Building());
	}

	@Override
	public Set<Building> listAll() {
		Set<Building> all = new HashSet<>();
		repo.findAll().forEach(e -> all.add(e));
		return all;
	}

	@Override
	public void update(Building object) {
		Building existing = get(object.getId());
		if(existing.getId() != null && existing.getId().equals(object.getId())){
			repo.save(existing.getUpdateCopy(object));
		}
	}

	@Override
	public void saveAll(Set<Building> objects) {
		repo.saveAll(objects);
	}

}
