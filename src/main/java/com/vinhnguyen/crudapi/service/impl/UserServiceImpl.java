package com.vinhnguyen.crudapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vinhnguyen.crudapi.criteria.UserCriteria;
import com.vinhnguyen.crudapi.entites.User;
import com.vinhnguyen.crudapi.repository.UserRepository;
import com.vinhnguyen.crudapi.service.UserService;
import com.vinhnguyen.crudapi.specification.UserSpecification;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll(String name, String email) {
		UserSpecification spec1 = new UserSpecification(new UserCriteria("name",":",name));
		UserSpecification spec2 = new UserSpecification(new UserCriteria("email",":",email));
		return userRepository.findAll(Specification.where(spec1).and(spec2));
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
