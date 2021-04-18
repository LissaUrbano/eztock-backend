package com.facens.ezstock.entities.dto;

import com.facens.ezstock.entities.Atributo;
import com.facens.ezstock.entities.AtributoProduto;

public class AtributoProdutoDto {
    
    private Long id;
    private Atributo atributo; //chave estrangeira 
    private String valor;

    public AtributoProdutoDto() {
    }

    public AtributoProdutoDto(Long id, Atributo atributo, String valor) {
        this.id = id;
        this.atributo = atributo;
        this.valor = valor;
    }

    public AtributoProdutoDto(AtributoProduto atributoProduto) {
        setId(atributoProduto.getId());
        setAtributo(atributoProduto.getAtributo());
        setValor(atributoProduto.getValor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
