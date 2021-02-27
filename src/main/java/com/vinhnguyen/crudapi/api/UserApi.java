package com.vinhnguyen.crudapi.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vinhnguyen.crudapi.entites.User;
import com.vinhnguyen.crudapi.service.UserService;
import com.vinhnguyen.crudapi.service.impl.UserServiceImpl;

@RestController
public class UserApi {

	@Autowired
	private UserService userService = new UserServiceImpl();

	@GetMapping("/api/user")
	public ResponseEntity<List<User>> findAll(@PathParam(value = "name") String name,
			@PathParam(value = "email") String email, @PathParam(value = "keySort") String keySort,
			@PathParam(value = "sortBy") String sortBy, @PathParam(value = "pageNumber") int pageNumber) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(name, email, keySort, sortBy, pageNumber));
	}

	@PostMapping("/api/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@Valid @RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/api/user/{id}")
	public User update(@Valid @RequestBody User user, @PathVariable("id") int id) {

		User newUser = userService.findById(id);
		if (newUser != null) {
			newUser.setName(user.getName() != null ? user.getName() : newUser.getName());
			newUser.setEmail(user.getEmail() != null ? user.getEmail() : newUser.getEmail());
			newUser.setPassword(user.getPassword() != null ? user.getPassword() : newUser.getPassword());
			return userService.save(newUser);
		}

		return null;
	}

	@DeleteMapping("/api/user/{id}")
	public void delete(@PathVariable("id") int id) {
		userService.detele(id);
	}
}
