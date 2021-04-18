package com.facens.ezstock.services;

import java.util.ArrayList;
import java.util.List;

import com.facens.ezstock.entities.Estoque;
import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.dto.ProdutoDto;
import com.facens.ezstock.repositories.EstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EstoqueService {

    private Estoque estoque = new Estoque();

    private String msgNotFound = "Produto não encontrado";

    @Autowired
    private EstoqueRepository estoqueRepository;

    public ProdutoDto inserir(ProdutoDto produtoDto) {
        Produto produto = new Produto(produtoDto);
        estoque.inserirProdutoLista(produto);
        return null;
    }

    public void remover(Long id) {
        try {
            estoqueRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public List<ProdutoDto> buscarTodos() {
		List<Produto> produtosEncontrados = estoque.getProdutosEstoque();
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
