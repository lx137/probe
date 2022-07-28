package com.example.probe.controller;

import com.example.probe.entity.Konto;
import com.example.probe.repository.KontoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/konto")                                                           //Pfad damit Ressourcen eindeutig identifizierbar sind
public class KontoController {

    private KontoRepository kontoRepository;

    public KontoController(KontoRepository kontoRepository) {                       //Konstruktor
        this.kontoRepository = kontoRepository;
    }

    @GetMapping("")                                                                //Definieren wie die Methode nach Außen abrufbar ist
    public List<Konto> findAll() {
        List<Konto> all = kontoRepository.findAll();
        return all;
    }

    @GetMapping("/{id}")
    public Optional<Konto> findById(@PathVariable String id){
        return kontoRepository.findById(Integer.valueOf(id));
    }

    @PostMapping("")
    public Konto addKonto(@RequestBody Konto newKonto) {
        return kontoRepository.save(newKonto);
    }

    @PutMapping()
    Konto replaceKonto(@RequestBody Konto newKonto) {
        return kontoRepository.save(newKonto);
    }

    // login und register endpunkt. course header

}
