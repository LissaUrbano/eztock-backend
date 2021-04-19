package com.facens.ezstock.repositories;

import com.facens.ezstock.entities.ProdutoEstoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, Long> {

    

}
