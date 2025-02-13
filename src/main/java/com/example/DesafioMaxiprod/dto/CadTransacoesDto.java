package com.example.DesafioMaxiprod.dto;

import com.example.DesafioMaxiprod.domain.CadPessoas;
import com.example.DesafioMaxiprod.domain.CadTransacoes;
import com.example.DesafioMaxiprod.domain.Tipo;

import java.io.Serializable;

public class CadTransacoesDto implements Serializable {
    private Integer idTransacoes;
    private String descricao;
    private Double valor;
    private Tipo tipo;
    private Integer idPessoa;

    public CadTransacoesDto(CadTransacoes obj){
        idTransacoes = obj.getIdTransacoes();
        descricao = obj.getDescricao();
        valor = obj.getValor();
        tipo = obj.getTipo();
        idPessoa = obj.getPessoas().getId();

    }

    public CadTransacoesDto(Integer idTransacoes, String descricao, Double valor,
                            Tipo tipo, Integer idPessoa) {

    }

    public CadTransacoesDto() {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public CadPessoas getPessoas() {
        return getPessoas();
    }
}
