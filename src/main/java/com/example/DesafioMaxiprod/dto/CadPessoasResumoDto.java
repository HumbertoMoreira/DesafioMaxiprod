package com.example.DesafioMaxiprod.dto;

import com.example.DesafioMaxiprod.domain.CadPessoas;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"id", "nome", "idade", "totalReceita", "totalDespesa", "saldo"})
public class CadPessoasResumoDto implements Serializable {
    private Integer id;
    private String nome;
    private Integer idade;
    private Double totalReceita;
    private Double totalDespesa;
    private Double saldo;

    public CadPessoasResumoDto(CadPessoas pessoa, Double totalReceita, Double totalDespesa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
        this.totalReceita = totalReceita;
        this.totalDespesa = totalDespesa;
        this.saldo = totalReceita - totalDespesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getTotalReceita() {
        return totalReceita;
    }

    public void setTotalReceita(Double totalReceita) {
        this.totalReceita = totalReceita;
    }

    public Double getTotalDespesa() {
        return totalDespesa;
    }

    public void setTotalDespesa(Double totalDespesa) {
        this.totalDespesa = totalDespesa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
