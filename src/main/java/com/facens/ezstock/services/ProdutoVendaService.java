package com.facens.ezstock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.ezstock.entities.ProdutoEstoque;
import com.facens.ezstock.entities.ProdutoVenda;
import com.facens.ezstock.entities.dto.ProdutoVendaDTO;
import com.facens.ezstock.repositories.ProdutoEstoqueRepository;
import com.facens.ezstock.repositories.ProdutoVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProdutoVendaService {

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    private String msgNotFound = "Produto não encontrado em venda";

    public ProdutoVendaDTO inserir(Long idEstoque, Integer qtd) {
                                    
        ProdutoEstoque produtoEstoque = produtoEstoqueRepository.findById(idEstoque).get();
        if (produtoEstoque == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        if (qtd <= 0 && qtd != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade inválida");
		}
        Integer qtdDisponivel = produtoEstoque.getQuantidade();
        if ((qtdDisponivel-qtd) >= 0 ) {
            produtoEstoque.setQuantidade((produtoEstoque.getQuantidade()) - qtd);
            ProdutoVendaDTO produtoVendaDTO = new ProdutoVendaDTO(qtd, produtoEstoque.getProduto());
            return new ProdutoVendaDTO(produtoVendaRepository.save(new ProdutoVenda(produtoVendaDTO)));
        } 
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade insuficiente para venda");
    }

    public List<ProdutoVendaDTO> buscarTodos() {
		List<ProdutoVenda> produtosEncontrados = produtoVendaRepository.findAll();
        if (produtosEncontrados.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listProdutoVendaDTO(produtosEncontrados);
	}

    public ProdutoVendaDTO atualizar(Long id, Integer qtd) { //atualiza somente qtd
        try {
            ProdutoVenda produtoVenda = produtoVendaRepository.getOne(id);
            if(qtd != null && qtd > 0) {
                produtoVenda.setQuantidade(qtd);
            }
            return new ProdutoVendaDTO(produtoVendaRepository.save(produtoVenda));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public void remover(Long id) {
        try {
            produtoVendaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public ProdutoVendaDTO buscarPorId(Long id) {
        Optional<ProdutoVenda> op = produtoVendaRepository.findById(id);
        ProdutoVenda produtoVenda = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound));
        return new ProdutoVendaDTO(produtoVenda);
    }

    private List<ProdutoVendaDTO> listProdutoVendaDTO(List<ProdutoVenda> produtosVenda){
        List<ProdutoVendaDTO> listProdutoVendaDTO = new ArrayList<>();
        for (ProdutoVenda produtoVenda : produtosVenda) {
            ProdutoVendaDTO produtoDto = new ProdutoVendaDTO(produtoVenda);
            listProdutoVendaDTO.add(produtoDto);
        }
        return listProdutoVendaDTO;
    }
}
