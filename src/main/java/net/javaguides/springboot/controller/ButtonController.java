package net.javaguides.springboot.controller;

import com.google.gson.Gson;
import net.javaguides.springboot.entity.Book;
import net.javaguides.springboot.entity.Button;
import net.javaguides.springboot.entity.Menu;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.ButtonRepository;
import net.javaguides.springboot.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ButtonController {

    Gson gson = new Gson();
    @Autowired
    private ButtonRepository buttonRespository;
    @Autowired
    private MenuRepository menuRespository;
//	@GetMapping("/user")
//	public List<User>getAllUser(){
//		return userRespository.findAll();
//	}

//	@PostMapping("/button")
//	public Button createButton(@RequestBody Button button) {
//	
//		return buttonRespository.save(button);
//	}

    @GetMapping("/button")
    public List<Button> getAllButton() {
        return buttonRespository.findAll();
    }

    @PostMapping("/button")
    public void createButton(@RequestBody Object object) {
        System.out.print(object);
        String json = gson.toJson(object);
        Book book = gson.fromJson(json, Book.class);
        Menu menu1 = book.getMenu().get(0);
        menuRespository.save(menu1);
        List<Button> button1 = book.getButton();
        for (int i = 0; i < button1.size(); i++) {
            button1.get(i).setMenu(menu1);
            buttonRespository.save(button1.get(i));
        }
    }

    @PostMapping("/createbutton")
    public Button createButton(@RequestBody Button button) {

        return buttonRespository.save(button);
    }

    @GetMapping("/getButtonByIDMenu/{id_menu}")
    public List<Button> listButtonByIdMenu(@PathVariable int id_menu) {
        return buttonRespository.listButtonByIdMenu(id_menu);
    }

    @PutMapping("/button/{id}")
    public ResponseEntity<Button> updateButton(@PathVariable int id, @RequestBody Button button) {

        Button button1 = buttonRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categories not exist with id :" + id));
        System.out.println(button1.getMenu());
        button1.setColor_background(button1.getColor_background());
        button1.setColor_icon(button1.getColor_icon());
        button1.setColor_text(button1.getColor_text());
        button1.setLink(button1.getLink());
        button1.setName_button(button1.getName_button());
        button1.setMenu(button1.getMenu());
        button1.setIcon(button1.getIcon());
        Button updatebutton = buttonRespository.save(button);
        return ResponseEntity.ok(updatebutton);
    }


    @GetMapping("countSumButtonCreated")
    ResponseEntity<?> countSumButtonCreated(@RequestParam(value = "email",required = true) String email){
        Integer value = buttonRespository.countSumButtonCreated(email);
        return (value!=null)?ResponseEntity.ok(value) : (ResponseEntity<?>) ResponseEntity.badRequest();
    }
    @GetMapping("statisticsClickByUrl")
    ResponseEntity<?> statisticsClickByUrl(@RequestParam(value = "email",required = true) String email){
        List<Object> list = buttonRespository.statisticsClickByUrl(email);
        return (list!=null)?ResponseEntity.ok(list) : (ResponseEntity<?>) ResponseEntity.badRequest();
    }
    @GetMapping("statisticsClickByButton")
    ResponseEntity<?> statisticsClickByButton(@RequestParam(value = "email",required = true) String email){
        List<Object> list = buttonRespository.statisticsClickByButton(email);
        return (list!=null)?ResponseEntity.ok(list) : (ResponseEntity<?>) ResponseEntity.badRequest();
    }

//	public static class Data{
//		private Menu menu;
//		private Button button;
//	}
//	@PostMapping("/button")
//	public Object createButton(@RequestBody Object data) {
////	buttonRespository.save(data);
////		System.out.println(data.getMenu().getMaMN());
////		menu.setMaMN(data.getMenu().getMaMN());
////		menu.setTenMN(data.getMenu().getTenMN());
////		menu.setStatus(false);
//		System.out.println(data);
//	
////		menuRespository.save(menu);
//		
////		System.out.println("s"+data.button);
//		return null;
//	}


}
