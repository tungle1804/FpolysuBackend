package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Button;
import net.javaguides.springboot.entity.DataOfCustomer;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.DataOfCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DataOfCustomerController {

    @Autowired
    private DataOfCustomerRepository dataOfCustomerRepository;

    @GetMapping("/dataofcustomer")
    public List<DataOfCustomer> getAllDataOfCustomer(){
        return dataOfCustomerRepository.findAll();
    }
    @PostMapping("/dataofcustomer")
    public DataOfCustomer createDataOfCustomer(@RequestBody DataOfCustomer dataOfCustomer) {

        return dataOfCustomerRepository.save(dataOfCustomer);
    }

    @GetMapping("/dataofcustomerbyid/{id}")
    public Optional<DataOfCustomer> getDataOfCustomersById(@PathVariable int id){
        return dataOfCustomerRepository.findById(id);
    }

    @GetMapping("/dataofcustomerbyuser/{email}")
    public List<DataOfCustomer> getDataOfCustomersByUsers(@PathVariable String email){
        return dataOfCustomerRepository.getDataOfCustomersByUsers(email);
    }
    @GetMapping("/search")
    public List<DataOfCustomer> getDataOfCustomersByFullName(@RequestParam(name = "keyword",required = false, defaultValue = "")String fullname){
        return dataOfCustomerRepository.getDataOfCustomerByFullName(fullname);
    }

    @PostMapping("/create")
    public DataOfCustomer createDataOfCustom(@RequestBody DataOfCustomer data){
        return dataOfCustomerRepository.save(data);
    }

    @PutMapping("/update")
    public DataOfCustomer updateDataOfCustomer(@RequestBody DataOfCustomer dataOfCustomer){
        DataOfCustomer existingData = dataOfCustomerRepository.findById(dataOfCustomer.getId()).orElse(null);
        existingData.setFullName(dataOfCustomer.getFullName());
        existingData.setPhone(dataOfCustomer.getPhone());
        existingData.setEmailCustomer(dataOfCustomer.getEmailCustomer());
        existingData.setAddress(dataOfCustomer.getAddress());
        existingData.setConTent(dataOfCustomer.getConTent());
        existingData.setNotes(dataOfCustomer.getNotes());
//        existingData.setUsers(dataOfCustomer.getUsers());
        return dataOfCustomerRepository.save(existingData);
    }

<<<<<<< HEAD
=======


>>>>>>> 36ef5c9d14449dbf46b9e59111b3bb94c0f9d30f
}
