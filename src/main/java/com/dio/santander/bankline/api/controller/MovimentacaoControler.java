package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoControler {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;


//    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Movimentacao> findAll() {
        List<Movimentacao> movimentacoes = repository.findAll();
        movimentacoes.forEach(x -> {
            x.setDataHora(x.getDataHora());
        });

        return movimentacoes;
    }

//    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody NovaMovimentacao novaMovimentacao) {
        service.save(novaMovimentacao);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{idConta}")
    @GetMapping("/{idConta}")
    public List<Movimentacao> findByIdConta(@PathVariable(value = "idConta") int idConta) {
        return repository.findByIdConta(idConta);
    }
}
