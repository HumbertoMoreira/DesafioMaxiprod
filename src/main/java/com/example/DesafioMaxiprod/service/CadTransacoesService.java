package com.example.DesafioMaxiprod.service;

import com.example.DesafioMaxiprod.domain.CadPessoas;
import com.example.DesafioMaxiprod.domain.CadTransacoes;
import com.example.DesafioMaxiprod.domain.Tipo;
import com.example.DesafioMaxiprod.dto.CadTransacoesDto;
import com.example.DesafioMaxiprod.repository.CadPessoasRepository;
import com.example.DesafioMaxiprod.repository.CadTransacoesRepository;
import com.example.DesafioMaxiprod.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadTransacoesService {

    @Autowired
    private CadTransacoesRepository cadTransacoesRepository;

    @Autowired
    private CadPessoasRepository cadPessoasRepository;

    public CadTransacoes insert(CadTransacoes obj){
        if (obj.getPessoas() == null || obj.getPessoas().getId() == null) {
            throw new IllegalArgumentException("O ID da pessoa é obrigatório!");
        }

        CadPessoas pessoa = cadPessoasRepository.findById(obj.getPessoas().getId())
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada!"));

        if (pessoa.getIdade() < 18 && obj.getTipo() == Tipo.RECEITA){
            throw new IllegalArgumentException("Menores de 18 anos só podem cadastrar transações do tipo DESPESA!");
        }

        obj.setIdTransacoes(null);
        obj = cadTransacoesRepository.save(obj);
        return obj;
    }

    public CadTransacoes find(Integer id){
        Optional<CadTransacoes> obj = cadTransacoesRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Transação não encontrada! Id: " + id + " " + CadTransacoes.class.getName()));
    }

    public List<CadTransacoes> findAll(){
        List<CadTransacoes> list = cadTransacoesRepository.findAll();
        return list;
    }

    public CadTransacoes update(CadTransacoes obj){
        CadTransacoes transacaoAtual = find(obj.getIdTransacoes());

        CadPessoas pessoa = transacaoAtual.getPessoas();

        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa associada à transação não encontrada!");
        }

        if (pessoa.getIdade() < 18 && obj.getTipo() == Tipo.RECEITA) {
            throw new IllegalArgumentException("Menores de 18 anos só podem ter transações do tipo DESPESA!");
        }

        updateData(transacaoAtual, obj);
        return cadTransacoesRepository.save(transacaoAtual);
    }

    private void updateData(CadTransacoes transacaoNew, CadTransacoes transacaoOld){
        transacaoNew.setDescricao(transacaoOld.getDescricao());
        transacaoNew.setValor(transacaoOld.getValor());
        transacaoNew.setTipo(transacaoOld.getTipo());
    }

    public CadTransacoes fromDto(CadTransacoesDto objDto) {
        return new CadTransacoes(
                objDto.getIdTransacoes(),
                objDto.getDescricao(),
                objDto.getValor(),
                objDto.getTipo(),
                new CadPessoas(objDto.getIdPessoa(), null, null));
    }

    public void delete(Integer id){
        if (!cadTransacoesRepository.existsById(id)) {
            throw new IllegalArgumentException("Transação não encontrada!");
        }
        cadTransacoesRepository.deleteById(id);
    }
}
