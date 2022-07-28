package com.example.probe;

import com.example.probe.entity.Login;
import com.example.probe.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    LoginRepository loginRepo;
    @GetMapping("/hello")
    @PostMapping("/login1")
    public String index() {

        return "Greetings from Spring Boot!";

    }

}