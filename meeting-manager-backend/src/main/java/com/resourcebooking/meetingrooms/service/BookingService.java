package com.resourcebooking.meetingrooms.service;

import java.util.HashSet;
import java.util.Set;

import com.resourcebooking.meetingrooms.entity.Booking;
import com.resourcebooking.meetingrooms.repository.BookingRepository;

public class BookingService implements BaseService<Booking, Long>{

	private BookingRepository repo;
	
	public BookingService(BookingRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Booking save(Booking object) {
		return repo.save(object);
	}

	@Override
	public void delete(Booking object) {
		deleteById(object.getId());	
	}

	@Override
	public Booking get(Long id) {
		return repo.findById(id).orElseGet(() -> new Booking());
	}

	@Override
	public Set<Booking> listAll() {
		Set<Booking> list = new HashSet<>();
		repo.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public void update(Booking object) {
		Booking existing = get(object.getId());
		if(existing.getId() != null) {
			existing.getUpdateCopy(object);
		}
		repo.save(object);
	}

	@Override
	public void saveAll(Set<Booking> objects) {
		repo.saveAll(objects);
		
	}

	@Override
	public void deleteById(Long id) {
		Booking existing = get(id);
		if(existing.getId() != null) {
			repo.deleteById(existing.getId());
		}
		
	}

}
