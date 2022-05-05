package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    public void save(NovoCorrentista novoCorrentista) {
        Conta conta = new Conta(new Date().getTime());
        Correntista correntista = new Correntista(null, novoCorrentista.getCpf(), novoCorrentista.getNome(), conta);

        repository.save(correntista);
    }
}
