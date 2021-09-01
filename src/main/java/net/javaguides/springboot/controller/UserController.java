package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.MenuRepository;
import net.javaguides.springboot.repository.PaymentHistoryRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
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

    @GetMapping("/sum-employee")
    public Integer sumEmplyee(){
        return userRepository.countByRole("employee");
    }

    @GetMapping("/sum-customer")
    public Integer sumCustomer(){
        return userRepository.countByRole("customer");
    }

    @GetMapping("/sum-menu")
    public Integer sumMenu(){
        return menuRepository.countAll();
    }

    @GetMapping("/total-price")
    public double totalPrice(){
      return paymentHistoryRepository.getTotalSumPrice();
    }

}
