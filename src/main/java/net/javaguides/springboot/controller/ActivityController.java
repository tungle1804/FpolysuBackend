package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Activity;
import net.javaguides.springboot.entity.Button;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.ActivityRepository;
import net.javaguides.springboot.repository.ButtonRepository;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class ActivityController {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ButtonRepository buttonRepository;
    @GetMapping("/activity")
    public List<Activity> getAllUser(){
        return activityRepository.findAll();
    }


    @PostMapping("/activity")
    public ResponseEntity createActivity(@RequestBody Activity activity) {

        return new ResponseEntity(activityRepository.save(activity), HttpStatus.OK);

    }

    @GetMapping("/activity/{id}")
    public Optional<Activity> getUserById(@PathVariable String id) {
        return activityRepository.findById(Integer.valueOf(id));
    }
}
