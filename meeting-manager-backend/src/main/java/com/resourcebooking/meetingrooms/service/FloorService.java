package com.resourcebooking.meetingrooms.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import com.resourcebooking.meetingrooms.entity.Floor;
import com.resourcebooking.meetingrooms.repository.FloorRepository;


public class FloorService implements BaseService<Floor, Long>{

	private FloorRepository repo;
	
	public FloorService(FloorRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Floor save(Floor object) {
		return repo.save(object);
	}

	@Override
	public void delete(Floor object) {
		Floor existing = get(object.getId());
		if(existing.getId() != null) {
			repo.delete(object);
		}
		
	}

	@Override
	public Floor get(Long id) {
		Optional<Floor> existing = repo.findById(id);
		return existing.orElseGet(() -> new Floor()) ;
	}

	@Override
	public Set<Floor> listAll() {
		Set<Floor> floors = new HashSet<Floor>();
		repo.findAll().forEach(e -> floors.add(e));
		return floors;
	}

	@Override
	public void update(Floor object) {
		Floor existing = get(object.getId());
		if(existing.getId() != null) {
			existing.getUpdateCopy(object);
		}
		repo.save(object);
	}

	@Override
	public void saveAll(Set<Floor> objects) {
		repo.saveAll(objects);
	}

}
