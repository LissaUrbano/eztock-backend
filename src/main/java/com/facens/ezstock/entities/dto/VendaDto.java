package com.facens.ezstock.entities.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.Venda;

public class VendaDto {

    private List<Produto> produtosVendidos = new ArrayList<>();
    private LocalDate dataVenda = LocalDate.now();
    
    public VendaDto(List<Produto> produtosVendidos, LocalDate dataVenda) {
        this.produtosVendidos = produtosVendidos;
        this.dataVenda = dataVenda;
    }

    public VendaDto(Venda venda) {
        setProdutosVendidos(venda.getProdutosVendidos());
        setDataVenda(venda.getDataVenda());
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

}
