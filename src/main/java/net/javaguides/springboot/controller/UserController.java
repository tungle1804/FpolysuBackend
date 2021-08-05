package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/user")
	public List<User>getAllUser(){
		return userRepository.findAll();
	}


	@PostMapping("/user")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		if (userService.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email đã tồn tại");
		}
		user.setPassword(encoder.encode(user.getPassword()));
		User dto = userRepository.save(user);
		return new ResponseEntity(dto, HttpStatus.OK);

	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		return userRepository.findById(id);
	}
}
