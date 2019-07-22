package com.java.demo.controllers;

import com.java.demo.models.User;
import com.java.demo.services.EmailService;
import com.java.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private UserService userService;

    @GetMapping("/")
    public String home(){
        System.out.println("you are at home");
        return "u are at home";
    }
    @GetMapping("/save")
    public User save(User user){
        System.out.println(user);
        return user;
    }

    @PostMapping("/save")
        public User saveUser(User user){
        System.out.println(user);
        userService.save(user);
        System.out.println(user);
            return user;
        }

        @GetMapping("/users")
        public List<User> users(){
            List<User> all = userService.findAll();
            return all;
        }

        @GetMapping("/user/{id}")
        public User getUser(@PathVariable int id) {
//          Optional<User> optionalUser = userService.findById(id);
//          User user = optionalUser.get();
            User user1 = userService.findById(id).get();
            return user1;
        }

        @PostMapping("/upload")
        public String upload(@RequestParam("filee") MultipartFile file) throws IOException {
        String path =  System.getProperty("user.home") + File.separator + "Pictures" + File.separator + file.getOriginalFilename();
        file.transferTo(new File(path));
            return "ok";
        }

        private EmailService emailService;

            @GetMapping("/email")
            public String sendEmail(@RequestParam String email, @RequestParam("file") MultipartFile file){
                System.out.println(email);
                emailService.sendEmail(email, file);
            return "";
            }
    }



