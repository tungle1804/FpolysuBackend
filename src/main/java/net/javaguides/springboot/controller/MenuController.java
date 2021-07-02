package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;

import net.javaguides.springboot.model.Menu;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.MenuRepository;
import net.javaguides.springboot.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
	@GetMapping("/menu")
	public List<Menu> getAllMenu() {
		return menuRepository.findAll();
	}
	@PostMapping("/menu")
	public Menu createMenu(@RequestBody Menu menu) {

		return menuRepository.save(menu);
	}
	@GetMapping("/menu/{id}")
	public Optional<Menu> getUserById(@PathVariable int id) {
		return menuRepository.findById(id);
	}
	@DeleteMapping("/menu/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMenu(@PathVariable int id) {
		Menu menu = menuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Menu not exist with id :" + id));
		menuRepository.delete(menu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/getMenuByEmail/{email}")
	public List<Menu> getButtonByEmail(@PathVariable String email) {
		return menuRepository.getMenuByEmail(email);
	}

	@PutMapping("/menu/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable int id, @RequestBody Menu menu) {

		Menu menu1 = menuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categories not exist with id :" + id));
		menu1.setStatus(menu.isStatus());
		Menu updateMenu = menuRepository.save(menu);
		return ResponseEntity.ok(updateMenu);
	}
	@GetMapping("/getMenuByStatus/{email}")
	public List<Menu> getMenuByStatus(@PathVariable String email) {
		return menuRepository.getMenuByStatus(email);
	}
	
}
