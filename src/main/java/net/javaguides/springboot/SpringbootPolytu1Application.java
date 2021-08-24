package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class SpringbootPolytu1Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootPolytu1Application.class, args);
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        System.out.println(date);
    }

}
