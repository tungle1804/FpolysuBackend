package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.ActivityButton;
import net.javaguides.springboot.repository.ActivityButtonRepository;
import net.javaguides.springboot.repository.ButtonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class ActivityButtonController {
    @Autowired
    private ActivityButtonRepository activityButtonRepository;

    @Autowired
    private ButtonRepository buttonRepository;
    @GetMapping("/activityButton")
    public List<ActivityButton> getAllUser(){
        return activityButtonRepository.findAll();
    }

//this is commnet testgit
    @PostMapping("/activityButton")
    public ResponseEntity createActivity(@RequestBody ActivityButton activity) {
try{
    return new ResponseEntity(activityButtonRepository.save(activity), HttpStatus.OK);
}catch (Exception e){
    return new ResponseEntity("Error"+e, HttpStatus.BAD_REQUEST);
}


    }

    @GetMapping("/activityButton/{id}")
    public Optional<ActivityButton> getUserById(@PathVariable String id) {
        return activityButtonRepository.findById(Integer.valueOf(id));
    }
    @GetMapping("/activityyButton")
    ResponseEntity<?> search(
//            @RequestParam(name = "input") String input,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit), Sort.by("id").descending());
            Page<ActivityButton> dtoPage = activityButtonRepository.findAll(pageRequest);
            if (dtoPage != null) {
                return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Khách hàng cần tìm không tồn tại", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body("Page Empty");
        }

    }
}
