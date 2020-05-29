package com.resourcebooking.meetingrooms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.resourcebooking.meetingrooms.entity.User;
import com.resourcebooking.meetingrooms.repository.UserRepository;

@Service
public class UserService implements BaseService<User, Long>{
	
	private UserRepository repo;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public User save(User object) {
		return repo.save(object);
	}

	@Override
	public void delete(User object) {
		if(get(object.getId()).getId() != null){
			repo.delete(object);
		}
	}

	@Override
	public User get(Long id) {
		Optional<User> result = repo.findById(id);
		User empty = new User();
		return result.orElseGet(()-> empty);
	}

	@Override
	public Set<User> listAll() {
		Set<User> list = new HashSet<>(); 
		repo.findAll().forEach( e -> list.add(e));
		return list;
	}

	@Override
	public void update(User object) {
		User existing = get(object.getId());
		if(existing.getId() != null && existing.getId().equals(object.getId())){
			repo.save(existing.getUpadteCopy(object));
		}
	}

	@Override
	public void saveAll(Set<User> objects) {
		repo.saveAll(objects);	
	}

}
