package com.facens.ezstock.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.facens.ezstock.entities.dto.ProdutoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoProduto;
    private String categoria;
    private Double preco;

    @JsonIgnore
	@OneToOne
    private List<AtributoProduto> atributoProduto;//list chave estrangeira

    public Produto() {
    }

    public Produto(ProdutoDto produtoDto) {
        this.id = produtoDto.getId();
        this.nome = produtoDto.getNome();
        this.codigoProduto = produtoDto.getCodigoProduto();
        this.categoria = produtoDto.getCategoria();
        this.preco = produtoDto.getPreco();
        this.atributoProduto = produtoDto.getAtributoProduto();
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
