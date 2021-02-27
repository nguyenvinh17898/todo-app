package com.vinhnguyen.crudapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vinhnguyen.crudapi.entites.User;
import com.vinhnguyen.crudapi.repository.UserRepository;
import com.vinhnguyen.crudapi.service.UserService;
import com.vinhnguyen.crudapi.specification.UserSpecificationsBuilder;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll(String name, String email, String keySort, String sortBy, int pageNumber) {
		UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
		if (name != null) {
			builder.with("name", ":", name);
		}
		if (email != null) {
			builder.with("email", ":", email);
		}
		Sort sort;
		if (keySort != null && sortBy != null) {
			if(sortBy.equals("asc")) {
				sort = Sort.by(keySort).ascending().and(Sort.by("id").descending());
			}
			else {
				sort = Sort.by(keySort).descending().and(Sort.by("id").descending());
			}
		} else {
			sort = Sort.by("id").descending();
		}
		Pageable page = PageRequest.of(pageNumber, 2, sort);
		Specification<User> spec = builder.build();
		return userRepository.findAll(spec, page).getContent();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		Optional<User> user = userRepository.findById(id);
		return !user.isEmpty() ? user.get() : null;
	}

	@Override
	public void detele(int id) {
		userRepository.deleteById(id);
	}
}
