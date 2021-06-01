package com.facens.ezstock.entities.dto;

import java.time.LocalDate;

import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.ProdutoVenda;

public class ProdutoVendaDTO {

    private Long id;
    private Integer quantidade;
    private LocalDate dataVenda;

    private Produto produto;

    public ProdutoVendaDTO() {
    }

    public ProdutoVendaDTO(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public ProdutoVendaDTO(ProdutoVenda produtoVenda) {
        setId(produtoVenda.getId());
        setProduto(produtoVenda.getProduto());
        setQuantidade(produtoVenda.getQuantidade());
        setDataVenda(produtoVenda.getDataVenda());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    
}
