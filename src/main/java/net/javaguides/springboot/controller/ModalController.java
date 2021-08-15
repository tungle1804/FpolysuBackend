package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Button;
import net.javaguides.springboot.entity.DataOfCustomer;
import net.javaguides.springboot.entity.Menu;
import net.javaguides.springboot.entity.Modal;
import net.javaguides.springboot.repository.MenuRepository;
import net.javaguides.springboot.repository.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ModalController {
    @Autowired
    private ModalRepository modalRepository;

    @PostMapping("/getModalByButton/{id}")
    public List<Modal> getModalByButton(@PathVariable int id){
        return modalRepository.getModalByIdButton(id);
    }
    @PostMapping("/createModal")
    public Modal createModal(@RequestBody Modal modal) {

        return modalRepository.save(modal);
    }

}
