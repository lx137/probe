package com.example.probe.controller;

import com.example.probe.entity.Login;
import com.example.probe.repository.LoginRepository;
import jdk.jshell.Snippet;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {                       //Konstruktor
        this.loginRepository = loginRepository;
    }

    @GetMapping("")
    public List<Login> index() {
        List<Login> all = loginRepository.findAll();
        return all;}

    @GetMapping("/confirm")                                   //AKTUELL
    public Login anmeldung(@RequestParam(value = "benutzername", required = true) String benutzername, @RequestParam(value = "passwort", required = true) String passwort){
       return loginRepository.findeAnmeldung(benutzername, passwort);}

    @GetMapping("/{id}")
    public Optional<Login> findById(@PathVariable String id){
        return loginRepository.findById(Integer.valueOf(id));
    }

    @PostMapping("")
    public Login addLogin(@RequestBody Login newLogin) {
        return loginRepository.save(newLogin);
    }

    @PutMapping("/login/{id}")
    Login repalceLogin(@RequestBody Login newLogin, @PathVariable String id){

        return loginRepository.findById(Integer.valueOf(id))
                .map(login -> {
                            login.setBenutzername(newLogin.getBenutzername());
                            login.setEmail(newLogin.getEmail());
                            login.setPasswort(newLogin.getPasswort());
                            return loginRepository.save(login);
                        })
                .orElseGet(() -> {
                    newLogin.setLoginId(Integer.valueOf(id));
                    return loginRepository.save(newLogin);
                });
    }



}
