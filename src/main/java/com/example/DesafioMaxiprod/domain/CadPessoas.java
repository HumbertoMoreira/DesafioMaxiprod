package com.example.DesafioMaxiprod.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CadPessoas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;


    @OneToMany(mappedBy = "pessoas", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CadTransacoes> transacoes = new ArrayList<>();

    public CadPessoas() {
    }

    public CadPessoas(Integer id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
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

    public List<CadTransacoes> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<CadTransacoes> transacoes) {
        this.transacoes = transacoes;
    }
}
