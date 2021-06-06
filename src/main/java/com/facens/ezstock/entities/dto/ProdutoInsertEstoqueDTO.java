package com.facens.ezstock.entities.dto;

import java.time.LocalDate;

public class ProdutoInsertEstoqueDTO {

    private Long id;
    private Integer quantidade;
    private LocalDate dataEstoque;

    private String nome;
    private String codigoProduto;
    private String categoria;
    private Double preco;
    private String tamanho;
    private Boolean ehUsado;
    private String imagem;

    public ProdutoInsertEstoqueDTO() {
    }

    public ProdutoInsertEstoqueDTO(Long id, Integer quantidade, LocalDate dataEstoque,     
                                    String nome, String codigoProduto, String categoria, Double preco, String tamanho, Boolean ehUsado, String imagem) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataEstoque = dataEstoque;

        this.nome = nome;
        this.codigoProduto = codigoProduto;
        this.categoria = categoria;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ehUsado = ehUsado;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
