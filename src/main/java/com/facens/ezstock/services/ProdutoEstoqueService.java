package com.facens.ezstock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.ezstock.entities.ProdutoEstoque;
import com.facens.ezstock.entities.dto.ProdutoEstoqueDTO;
import com.facens.ezstock.repositories.ProdutoEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProdutoEstoqueService {

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    private String msgNotFound = "Produto não encontrado em estoque";

    public ProdutoEstoqueDTO criar(ProdutoEstoqueDTO produtoEstoqueDto) {
        ProdutoEstoque produtoEstoque = new ProdutoEstoque(produtoEstoqueDto);
        return new ProdutoEstoqueDTO(produtoEstoqueRepository.save(produtoEstoque));
    }

    public ProdutoEstoqueDTO atualizar(Long id, ProdutoEstoqueDTO produtoEstoqueDto) { //atualiza somente qtd
        try {
            ProdutoEstoque produtoEstoque = produtoEstoqueRepository.getOne(id);
            if(produtoEstoqueDto.getQuantidade() != null) {
                produtoEstoque.setQuantidade(produtoEstoqueDto.getQuantidade());
            }
            return new ProdutoEstoqueDTO(produtoEstoqueRepository.save(produtoEstoque));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public void remover(Long id) {
        try {
            produtoEstoqueRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public List<ProdutoEstoqueDTO> buscarTodos() {
		List<ProdutoEstoque> produtosEncontrados = produtoEstoqueRepository.findAll();
        if (produtosEncontrados.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listProdutoEstoqueDTO(produtosEncontrados);
	}

    public ProdutoEstoqueDTO buscarPorId(Long id) {
        Optional<ProdutoEstoque> op = produtoEstoqueRepository.findById(id);
        ProdutoEstoque produtoEstoque = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound));
        return new ProdutoEstoqueDTO(produtoEstoque);
    }

    private List<ProdutoEstoqueDTO> listProdutoEstoqueDTO(List<ProdutoEstoque> produtosEstoque){
        List<ProdutoEstoqueDTO> listProdutoEstoqueDTO = new ArrayList<>();
        for (ProdutoEstoque produtoEstoque : produtosEstoque) {
            ProdutoEstoqueDTO produtoDto = new ProdutoEstoqueDTO(produtoEstoque);
            listProdutoEstoqueDTO.add(produtoDto);
        }
        return listProdutoEstoqueDTO;
    }
    
}
