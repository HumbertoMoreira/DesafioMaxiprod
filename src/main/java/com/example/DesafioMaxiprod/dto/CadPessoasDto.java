package com.example.DesafioMaxiprod.dto;

import com.example.DesafioMaxiprod.domain.CadPessoas;

import java.io.Serializable;

public class CadPessoasDto implements Serializable {
    private Integer id;
    private String nome;
    private Integer idade;


    public CadPessoasDto(CadPessoas obj){
        id = obj.getId();
        nome = obj.getNome();
        idade = obj.getIdade();
    }

    public CadPessoasDto(Integer id, String nome, Integer idade) {

    }

    public CadPessoasDto() {
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
}
