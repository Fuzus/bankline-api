package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/correntistas")
public class CorrentistaControler {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;


//    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Correntista> findAll() {
        return repository.findAll();
    }

//    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody NovoCorrentista novoCorrentista) {
        service.save(novoCorrentista);
    }
}
