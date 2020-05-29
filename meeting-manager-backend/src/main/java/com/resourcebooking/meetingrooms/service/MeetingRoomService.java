package com.resourcebooking.meetingrooms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.resourcebooking.meetingrooms.entity.MeetingRoom;
import com.resourcebooking.meetingrooms.repository.MeetingRoomRepository;

@Service
public class MeetingRoomService implements BaseService<MeetingRoom, Long>{
	
	private MeetingRoomRepository repo;
	
	public MeetingRoomService(MeetingRoomRepository repo) {
		this.repo = repo;
	}

	@Override
	public MeetingRoom save(MeetingRoom object) {
		return repo.save(object);
	}

	@Override
	public void delete(MeetingRoom object) {
		deleteById(object.getId());
	}
	
	@Override
	public MeetingRoom get(Long id) {
		Optional<MeetingRoom> existing = repo.findById(id);
		return existing.orElseGet(() -> new MeetingRoom());
	}

	@Override
	public Set<MeetingRoom> listAll() {
		Set<MeetingRoom> rooms = new HashSet<MeetingRoom>();
		repo.findAll().forEach(e -> rooms.add(e));
		return rooms;
	}

	@Override
	public void update(MeetingRoom object) {
		MeetingRoom existing = get(object.getId());
		if(existing.getId() != null)
			existing.getUpdateCopy(object);
		repo.save(object);
	}

	@Override
	public void saveAll(Set<MeetingRoom> objects) {
		repo.saveAll(objects);
	}

	@Override
	public void deleteById(Long id) {
		MeetingRoom existing = get(id);
		if(existing.getId() != null)
			repo.deleteById(existing.getId());	
		
	}
}
