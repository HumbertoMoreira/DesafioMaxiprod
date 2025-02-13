package com.example.DesafioMaxiprod.service;

import com.example.DesafioMaxiprod.domain.CadPessoas;
import com.example.DesafioMaxiprod.domain.Tipo;
import com.example.DesafioMaxiprod.dto.CadPessoasDto;
import com.example.DesafioMaxiprod.dto.CadPessoasResumoDto;
import com.example.DesafioMaxiprod.repository.CadPessoasRepository;
import com.example.DesafioMaxiprod.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CadPessoaService {

    @Autowired
    private CadPessoasRepository cadPessoasRepository;

    public CadPessoas insert(CadPessoas obj){
        obj.setId(null);
        obj = cadPessoasRepository.save(obj);
        return obj;
    }

    public CadPessoas find(Integer id){
        Optional<CadPessoas> obj = cadPessoasRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Pessoa não encontrada Id: " + id + " " + CadPessoas.class.getName()));
    }

    public List<Object> findAll(){
        List<CadPessoas> list = cadPessoasRepository.findAll();
        List<CadPessoasResumoDto> resumoPessoas = new ArrayList<>();

        double totalReceitasGerais = 0.0;
        double totalDespesasGerais = 0.0;

        for (CadPessoas pessoa : list) {
            double totalReceita = pessoa.getTransacoes().stream()
                    .filter(t -> t.getTipo() == Tipo.RECEITA)
                    .mapToDouble(t -> t.getValor())
                    .sum();

            double totalDespesa = pessoa.getTransacoes().stream()
                    .filter(t -> t.getTipo() == Tipo.DESPESA)
                    .mapToDouble(t -> t.getValor())
                    .sum();

            totalReceitasGerais += totalReceita;
            totalDespesasGerais += totalDespesa;

            resumoPessoas.add(new CadPessoasResumoDto(pessoa, totalReceita, totalDespesa));
        }

        double saldoGeral = totalReceitasGerais - totalDespesasGerais;

        Map<String, Object> resumoGeral = new HashMap<>();
        resumoGeral.put("totalReceitaGeral", totalReceitasGerais);
        resumoGeral.put("totalDespesaGeral", totalDespesasGerais);
        resumoGeral.put("saldoGeral", saldoGeral);

        List<Object> resultadoFinal = new ArrayList<>();
        resultadoFinal.addAll(resumoPessoas);
        resultadoFinal.add(resumoGeral);
        return resultadoFinal;

    }

    public CadPessoas update(CadPessoas obj){
        CadPessoas cadPessoasAtt = find(obj.getId());
        updateData(cadPessoasAtt, obj);
        return cadPessoasRepository.save(cadPessoasAtt);
    }

    private void updateData(CadPessoas cadPessoasNew, CadPessoas cadPessoasOld){
        cadPessoasNew.setNome(cadPessoasOld.getNome());
        cadPessoasNew.setIdade(cadPessoasOld.getIdade());
    }

    public CadPessoas fromDto(CadPessoasDto objDto){
        return new CadPessoas(objDto.getId(), objDto.getNome(), objDto.getIdade());

    }

    public void delete(Integer id){
        if (!cadPessoasRepository.existsById(id)) {
            throw new IllegalArgumentException("Pessoa não encontrada!");
        }
        cadPessoasRepository.deleteById(id);
    }
}
