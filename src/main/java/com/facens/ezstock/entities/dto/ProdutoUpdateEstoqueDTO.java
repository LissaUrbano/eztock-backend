package com.facens.ezstock.entities.dto;

public class ProdutoUpdateEstoqueDTO {

    private Integer quantidade;

    public ProdutoUpdateEstoqueDTO() {
    }

    public ProdutoUpdateEstoqueDTO(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
