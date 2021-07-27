package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user")
	public List<User>getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping("/user")
	public User createUsers(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		return userRepository.findById(id);
	}
}
