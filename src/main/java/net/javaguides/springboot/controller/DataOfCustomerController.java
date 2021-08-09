package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.DataOfCustomer;
import net.javaguides.springboot.repository.DataOfCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dataofcustomer")

public class DataOfCustomerController {

    @Autowired
    private DataOfCustomerRepository dataOfCustomerRepository;

    @GetMapping("")
    public List<DataOfCustomer> getAllDataOfCustomer(){
        return dataOfCustomerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DataOfCustomer> getDataOfCustomersById(@PathVariable int id){
        return dataOfCustomerRepository.findById(id);
    }

    @GetMapping("/search")
    public List<DataOfCustomer> getDataOfCustomersByFullName(@RequestParam(name = "keyword",required = false, defaultValue = "")String fullname){
        return dataOfCustomerRepository.getDataOfCustomerByFullName(fullname);
    }
    @PostMapping("add")
    public void save(@RequestBody DataOfCustomer data){
        dataOfCustomerRepository.save(data);
    }

}
