package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.ActivityButton;
import net.javaguides.springboot.entity.ActivityMenu;
import net.javaguides.springboot.repository.ActivityButtonRepository;
import net.javaguides.springboot.repository.ActivityMenuRepository;
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
public class ActivityMenuController {
    @Autowired
    private ActivityMenuRepository activityMenuRepository;
    private ActivityButtonRepository activityButtonRepository;

    @Autowired
    private ButtonRepository buttonRepository;
    @GetMapping("/activityMenu")
    public List<ActivityMenu> getAllUser(){
        return activityMenuRepository.findAll();
    }

    //this is commnet testgit
    @PostMapping("/activityMenu")
    public ResponseEntity createActivity(@RequestBody ActivityMenu activity) {

        return new ResponseEntity(activityMenuRepository.save(activity), HttpStatus.OK);

    }

    @GetMapping("/activityMenu/{id}")
    public Optional<ActivityMenu> getUserById(@PathVariable String id) {
        return activityMenuRepository.findById(Integer.valueOf(id));
    }
    @GetMapping("/activityyMenu")
    ResponseEntity<?> search(
//            @RequestParam(name = "input") String input,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit), Sort.by("id").descending());
            Page<ActivityMenu> dtoPage = activityMenuRepository.findAll(pageRequest);
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
    @GetMapping("/statisticAllActionOnThisMenuEnable")
    ResponseEntity<?> statisticAllActionOnThisMenuEnable(
            @RequestParam(name = "email",required = true)String email,
           // @RequestParam(name = "hour", required = true) String hour,
            @RequestParam(name = "day",  required = true) String day,
            @RequestParam(name = "month", required = true) String month,
            @RequestParam(name = "year", required = true) String year
    ) {
        try {
            List<Integer> list=null;
            for (int i = 0; i <24 ; i++) {
            Integer dtoPage = activityMenuRepository.statisticAllActionOnThisMenuEnable(email,Integer.parseInt(String.valueOf(i)),
                    Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year));
            list.add(dtoPage);
            }

//            int dtoPage = activityMenuRepository.statisticAllActionOnThisMenuEnable(email,Integer.parseInt(hour),
//                    Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year));
            return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
         //       return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Page Empty"+e);
        }

    }
    @GetMapping("/getTotalNumberClickOnMenu")
    ResponseEntity<?> getTotalNumberClickOnMenu(
           @RequestParam(name = "email") String email,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit));
            Page<Object[]> dtoPage = activityMenuRepository.getTotalNumberClickOnMenu(email,pageRequest);
            if (dtoPage != null) {
                return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data need search not exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body("Page Empty");
        }

    }
    @GetMapping("/getTotalNumberActionDisplayOnMenu")
    ResponseEntity<?> getTotalNumberActionDisplayOnMenu(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit));
            Page<Object[]> dtoPage = activityMenuRepository.getTotalNumberActionDisplayOnMenu(email,pageRequest);
            if (dtoPage != null) {
                return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data need search not exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body("Page Empty");
        }

    }
    @GetMapping("/getTotalNumberActionDisplayOnButtonByType")
    ResponseEntity<?> getTotalNumberActionDisplayOnButtonByType(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit));
            Page<Object[]> dtoPage = activityMenuRepository.getTotalNumberActionDisplayOnButtonByType(email,pageRequest);
            if (dtoPage != null) {
                return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data need search not exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body("Page Empty");
        }

    }
    @GetMapping("/getTotalNumberClickOnButtonByType")
    ResponseEntity<?> getTotalNumberClickOnButtonByType(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit));
            Page<Object[]> dtoPage = activityMenuRepository.getTotalNumberClickOnButtonByType(email,pageRequest);
            if (dtoPage != null) {
                return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data need search not exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body("Page Empty");
        }

    }
    @GetMapping("/getStatisticInformationOfAction")
    ResponseEntity<?> getStatisticInformationOfAction(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) String pageNo,
            @RequestParam(name = "limit", defaultValue = "5", required = false) String limit
    ) {
        try {
            PageRequest pageRequest = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(limit), Sort.by("id").descending());
            Page<Object[]> dtoPage = activityMenuRepository.getStatisticInformationOfAction(email,pageRequest);
            if (dtoPage != null) {
                return new ResponseEntity<>(dtoPage, new HttpHeaders(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data need search not exist", new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest().body("Page Empty");
        }

    }
}