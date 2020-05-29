package com.resourcebooking.meetingrooms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.resourcebooking.meetingrooms.entity.Floor;
import com.resourcebooking.meetingrooms.repository.FloorRepository;

@Service
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
		deleteById(object.getId());
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

	@Override
	public void deleteById(Long id) {
		Floor existing = get(id);
		if(existing.getId() != null) {
			repo.deleteById(existing.getId());
		}
	}

}
