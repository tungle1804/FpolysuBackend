package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.DataOfCustomer;
import net.javaguides.springboot.repository.DataOfCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
