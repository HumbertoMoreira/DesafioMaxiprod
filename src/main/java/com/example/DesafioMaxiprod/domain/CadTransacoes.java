package com.example.DesafioMaxiprod.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTransacoes")
public class CadTransacoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransacoes;
    private String descricao;
    private double valor;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;


    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private CadPessoas pessoas;

    public CadTransacoes() {
    }

    public CadTransacoes(Integer idTransacoes, String descricao, double valor,
                         Tipo tipo, CadPessoas pessoas) {
        this.idTransacoes = idTransacoes;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.pessoas = pessoas;
    }

    public Integer getIdTransacoes() {
        return idTransacoes;
    }

    public void setIdTransacoes(Integer idTransacoes) {
        this.idTransacoes = idTransacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public CadPessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(CadPessoas pessoas) {
        this.pessoas = pessoas;
    }
}
