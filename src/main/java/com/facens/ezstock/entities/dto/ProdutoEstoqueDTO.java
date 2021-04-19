package com.facens.ezstock.entities.dto;

import java.time.LocalDate;

import com.facens.ezstock.entities.ProdutoEstoque;

public class ProdutoEstoqueDTO {

    private Long id;
    private Long idProduto;
    private Integer quantidade;
    private LocalDate dataEstoque;

    public ProdutoEstoqueDTO() {
    }

    public ProdutoEstoqueDTO(Long id, Long idProduto, Integer quantidade, LocalDate dataEstoque) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataEstoque = dataEstoque;
    }

    public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
        setId(produtoEstoque.getId());
        setIdProduto(produtoEstoque.getIdProduto());
        setQuantidade(produtoEstoque.getQuantidade());
        setDataEstoque(produtoEstoque.getDataEstoque());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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
    
}
