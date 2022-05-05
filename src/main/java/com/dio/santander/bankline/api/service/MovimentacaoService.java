package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.TipoMovimentacao;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao) {
        Double valor = novaMovimentacao.getTipo() == TipoMovimentacao.RECEITA ?
                novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        Movimentacao movimentacao = new Movimentacao(
                null,
                LocalDateTime.now(),
                novaMovimentacao.getDescricao(),
                valor,
                novaMovimentacao.getTipo(),
                novaMovimentacao.getIdConta()
        );
        Correntista correntista = correntistaRepository.findById(movimentacao.getIdConta()).orElse(null);

        if (correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }
}
