package com.resourcebooking.meetingrooms.service;

import java.util.Set;

public interface BaseService<T, ID> {
	 T save(T object);
	 void delete(T object);
	 T get(ID id);
	 Set<T> listAll();
	 void update(T object);
	 void saveAll(Set<T> objects);
}
