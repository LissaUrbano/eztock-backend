package com.facens.ezstock.repositories;

import com.facens.ezstock.entities.AtributoProduto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtributosDoProdutoRepository extends JpaRepository<AtributoProduto, Long>{
    
}
