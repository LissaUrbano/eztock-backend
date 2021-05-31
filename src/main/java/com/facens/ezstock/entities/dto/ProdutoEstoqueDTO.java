package com.facens.ezstock.entities.dto;

import java.time.LocalDate;

import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.ProdutoEstoque;

public class ProdutoEstoqueDTO {

    private Long id;
    private Integer quantidade;
    private LocalDate dataEstoque;

    private Produto produto;

    public ProdutoEstoqueDTO() {
    }

    public ProdutoEstoqueDTO(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
        setId(produtoEstoque.getId());
        setQuantidade(produtoEstoque.getQuantidade());
        setDataEstoque(produtoEstoque.getDataEstoque());
        setProduto(produtoEstoque.getProduto());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataEstoque() {
        return dataEstoque;
    }

    public void setDataEstoque(LocalDate dataEstoque) {
        this.dataEstoque = dataEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
