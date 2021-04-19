package com.facens.ezstock.entities.dto;

import java.time.LocalDate;

import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.ProdutoVenda;

public class ProdutoVendaDTO {

    private Long id;
    private Produto idProduto;
    private Integer quantidade;
    private LocalDate dataVenda;

    public ProdutoVendaDTO() {
    }

    public ProdutoVendaDTO(Long id, Produto idProduto, Integer quantidade, LocalDate dataVenda) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    public ProdutoVendaDTO(ProdutoVenda produtoVenda) {
        setId(produtoVenda.getId());
        setIdProduto(produtoVenda.getIdProduto());
        setQuantidade(produtoVenda.getQuantidade());
        setDataVenda(produtoVenda.getDataVenda());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
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
