package com.facens.ezstock.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.facens.ezstock.entities.dto.ProdutoEstoqueDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProdutoEstoque implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto idProduto;//chave estrangeira
    private Integer quantidade;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEstoque; 

    public ProdutoEstoque() {
    }

    public ProdutoEstoque(ProdutoEstoqueDTO produtoEstoqueDto) {
        setIdProduto(produtoEstoqueDto.getIdProduto());
        setQuantidade(produtoEstoqueDto.getQuantidade());
        setDataEstoque(LocalDate.now());
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

    public LocalDate getDataEstoque() {
        return dataEstoque;
    }

    public void setDataEstoque(LocalDate dataEstoque) {
        this.dataEstoque = dataEstoque;
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
        ProdutoEstoque other = (ProdutoEstoque) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
