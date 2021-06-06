package com.facens.ezstock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.ezstock.entities.Produto;
import com.facens.ezstock.entities.ProdutoEstoque;
import com.facens.ezstock.entities.ProdutoVenda;
import com.facens.ezstock.entities.dto.ProdutoDto;
import com.facens.ezstock.repositories.ProdutoEstoqueRepository;
import com.facens.ezstock.repositories.ProdutoRepository;
import com.facens.ezstock.repositories.ProdutoVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    private String msgNotFound = "Produto não encontrado";
    
    public Produto criar(ProdutoDto produtoDto) {
        return produtoRepository.save(new Produto(produtoDto));
    }

    public ProdutoDto atualizar(Long id, ProdutoDto produtoDto) { 
        try {
            Produto produto = produtoRepository.getOne(id);
            //não seta valores Null que vieram do DTO
            if(produtoDto.getNome() != null) {
                produto.setNome(produtoDto.getNome());
            }
            if(produtoDto.getCodigoProduto() != null) {
                produto.setCodigoProduto(produtoDto.getCodigoProduto());
            }
            if (produtoDto.getPreco() != null) {
                produto.setPreco(produtoDto.getPreco());
            }
            if (produtoDto.getCategoria() != null) {
                produto.setCategoria(produtoDto.getCategoria()); 
            }
            if (produtoDto.getEhUsado() != null){
                produto.setTamanho(produtoDto.getTamanho());
            }
            if (produtoDto.getImagem() != null){
                produto.setImagem(produtoDto.getImagem());
            }

            produto = produtoRepository.save(produto);
            return new ProdutoDto(produto);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public void remover(Long id) {

        Produto produto = produtoRepository.getOne(id);
        List<ProdutoEstoque> produtosEstoque = produtoEstoqueRepository.findAll();
        List<ProdutoVenda> produtosVenda = produtoVendaRepository.findAll();

        for (ProdutoEstoque produtoEstoque : produtosEstoque) {
            if ((produtoEstoque.getProduto()).equals(produto)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "produto não pode ser excluído");
            }  
        }

        for (ProdutoVenda produtoVenda : produtosVenda) {
            if ((produtoVenda.getProduto()).equals(produto)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "produto não pode ser excluído");
            }
        }

        try {
            produtoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public List<ProdutoDto> buscarTodos() {
		List<Produto> produtosEncontrados = produtoRepository.findAll();
        if (produtosEncontrados.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listProdutoDto(produtosEncontrados);
	}

    public ProdutoDto buscarPorId(Long id) {
        Optional<Produto> op = produtoRepository.findById(id);
        Produto produto = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound));
        return new ProdutoDto(produto);
    }
    
    public List<ProdutoDto> buscarPorCodigo(String codigo) {
		List<Produto> produtosEncontrados = produtoRepository.findByCodigoProdutoContainingIgnoreCase(codigo);
        if (produtosEncontrados == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listProdutoDto(produtosEncontrados);
	}
    
    public List<ProdutoDto> buscarPorNome(String nome) {
		List<Produto> produtosEncontrados = produtoRepository.findByNomeContainingIgnoreCase(nome);
        if (produtosEncontrados == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listProdutoDto(produtosEncontrados);
	}
	 
    public List<ProdutoDto> buscarPorCategoria(String categoria) {
        List<Produto> produtosEncontrados = produtoRepository.findByCategoriaContainingIgnoreCase(categoria); 
        if (produtosEncontrados == null) {
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
