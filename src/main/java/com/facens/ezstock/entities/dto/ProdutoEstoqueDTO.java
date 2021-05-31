package com.facens.ezstock.entities.dto;

import java.time.LocalDate;

import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.ProdutoEstoque;

public class ProdutoEstoqueDTO {

    private Long id;
    private Integer quantidade;
    private LocalDate dataEstoque;

    private Produto idProduto;

    public ProdutoEstoqueDTO() {
    }

    public ProdutoEstoqueDTO(Integer quantidade, Produto idProduto) {
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }

    public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
        setId(produtoEstoque.getId());
        setQuantidade(produtoEstoque.getQuantidade());
        setDataEstoque(produtoEstoque.getDataEstoque());
        setIdProduto(produtoEstoque.getIdProduto());
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

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }
}
