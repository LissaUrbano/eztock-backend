package com.facens.ezstock.repositories;

import com.facens.ezstock.entities.AtributoProduto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtributosDoProdutoRepository extends JpaRepository<AtributoProduto, Long>{
    
}
