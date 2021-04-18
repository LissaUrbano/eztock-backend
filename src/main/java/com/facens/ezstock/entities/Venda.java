package com.facens.ezstock.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Produto> produtosVendidos = new ArrayList<>();
    private LocalDate dataVenda = LocalDate.now();
    
    public Venda() {
    }

    public Venda(List<Produto> produtosVendidos, LocalDate dataVenda) {
        this.produtosVendidos = produtosVendidos;
        this.dataVenda = dataVenda;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void inserirProdutoLista(Produto produto){
        produtosVendidos.add(produto);
    }

    public void excluirProdutoLista(Produto produto){
        produtosVendidos.remove(produto); 
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((produtosVendidos == null) ? 0 : produtosVendidos.hashCode());
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
        Venda other = (Venda) obj;
        if (dataVenda == null) {
            if (other.dataVenda != null)
                return false;
        } else if (!dataVenda.equals(other.dataVenda))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (produtosVendidos == null) {
            if (other.produtosVendidos != null)
                return false;
        } else if (!produtosVendidos.equals(other.produtosVendidos))
            return false;
        return true;
    }
}
