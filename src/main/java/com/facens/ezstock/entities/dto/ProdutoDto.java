package com.facens.ezstock.entities.dto;

import java.util.List;

import com.facens.ezstock.entities.AtributoProduto;
import com.facens.ezstock.entities.Produto;

public class ProdutoDto {

    private Long id;
    private String nome;
    private String codigoProduto;
    private String categoria;
    private Double preco;
    private List<AtributoProduto> atributoProduto;

    public ProdutoDto() {
    }

    public ProdutoDto(Long id, String nome, String codigoProduto, String categoria, Double preco,
            List<AtributoProduto> atributoProduto) {
        this.id = id;
        this.nome = nome;
        this.codigoProduto = codigoProduto;
        this.categoria = categoria;
        this.preco = preco;
        this.atributoProduto = atributoProduto;
    }

    public ProdutoDto(Produto produto) {
        setId(produto.getId());
        setNome(produto.getNome());
        setCodigoProduto(produto.getCodigoProduto());
        setCategoria(produto.getCategoria());
        setPreco(produto.getPreco());
        setAtributoProduto(produto.getAtributoProduto());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<AtributoProduto> getAtributoProduto() {
        return atributoProduto;
    }

    public void setAtributoProduto(List<AtributoProduto> atributoProduto) {
        this.atributoProduto = atributoProduto;
    }
    
}
