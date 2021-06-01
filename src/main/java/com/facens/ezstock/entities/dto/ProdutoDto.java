package com.facens.ezstock.entities.dto;

import com.facens.ezstock.entities.Produto;

public class ProdutoDto {

    private Long id;
    private String nome;
    private String codigoProduto;
    private String categoria;
    private Double preco;
    private String tamanho;
    private Boolean ehUsado;

    public ProdutoDto() {
    }

    public ProdutoDto(String nome, String codigoProduto, String categoria, Double preco, String tamanho, Boolean ehUsado) {
        this.nome = nome;
        this.codigoProduto = codigoProduto;
        this.categoria = categoria;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ehUsado = ehUsado;
    }

    public ProdutoDto(Produto produto) {
        setId(produto.getId());
        setNome(produto.getNome());
        setCodigoProduto(produto.getCodigoProduto());
        setCategoria(produto.getCategoria());
        setPreco(produto.getPreco());
        setTamanho(produto.getTamanho());
        setEhUsado(produto.getEhUsado());
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Boolean getEhUsado() {
        return ehUsado;
    }

    public void setEhUsado(Boolean ehUsado) {
        this.ehUsado = ehUsado;
    }
}
