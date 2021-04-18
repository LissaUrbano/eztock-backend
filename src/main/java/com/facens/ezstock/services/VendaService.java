package com.facens.ezstock.services;

import com.facens.ezstock.repositories.VendaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.facens.ezstock.entities.Estoque;
import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.Venda;
import com.facens.ezstock.entities.dto.ProdutoDto;
import com.facens.ezstock.entities.dto.VendaDto;
import com.facens.ezstock.repositories.EstoqueRepository;
import com.facens.ezstock.repositories.ProdutoRepository;
import com.facens.ezstock.repositories.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VendaService {

    private Venda venda = new Venda();

    private String msgNotFound = "Produto não encontrado";

    @Autowired
    private VendaRepository vendaRepository;

    public ProdutoDto inserir(ProdutoDto produtoDto) {
        Produto produto = new Produto(produtoDto);
        venda.inserirProdutoLista(produto);
        return null;
    }

    public void remover(Long id) {
        try {
            vendaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public List<ProdutoDto> buscarTodos() {
		List<Produto> produtosEncontrados = venda.getProdutosVendidos();
        if (produtosEncontrados.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listProdutoDto(produtosEncontrados);
	}

    private List<ProdutoDto> listProdutoDto(List<Produto> produtos){
        List<ProdutoDto> listProdutoDto = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDto produtoDto = new ProdutoDto(produto);
            listProdutoDto.add(produtoDto);
        }
        return listProdutoDto;
    }
    
}
