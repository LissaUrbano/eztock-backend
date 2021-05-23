package com.facens.ezstock.repositories;

import java.util.List;

import com.facens.ezstock.entities.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
	List<Produto> findByNomeContainingIgnoreCase(String nome);
	List<Produto> findByCodigoProdutoContainingIgnoreCase(String codigo);
	List<Produto> findAllByOrderByNomeAsc();
	List<Produto> findAllByOrderByNomeDesc();
	List<Produto> findByCategoriaContainingIgnoreCase(String categoria);
	List<Produto> findByTamanhoContainingIgnoreCase(String nome);
	//find isNOVO bolean
}
