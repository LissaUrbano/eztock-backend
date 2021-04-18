package com.facens.ezstock.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Produto> produtosEstoque = new ArrayList<>();

    public Estoque() {
    }

    public Estoque(List<Produto> produtosEstoque) {
        this.produtosEstoque = produtosEstoque;
    }
    
    public List<Produto> getProdutosEstoque() {
        return produtosEstoque;
    }
    public void setProdutosEstoque(List<Produto> produtosEstoque) {
        this.produtosEstoque = produtosEstoque;
    }

    public void inserirProdutoLista(Produto produto){
        produtosEstoque.add(produto);
    }

    public void excluirProdutoLista(Produto produto){
        produtosEstoque.remove(produto); 
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((produtosEstoque == null) ? 0 : produtosEstoque.hashCode());
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
        Estoque other = (Estoque) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (produtosEstoque == null) {
            if (other.produtosEstoque != null)
                return false;
        } else if (!produtosEstoque.equals(other.produtosEstoque))
            return false;
        return true;
    }

}
