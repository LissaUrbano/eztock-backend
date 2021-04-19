package com.facens.ezstock.repositories;

import com.facens.ezstock.entities.ProdutoVenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoVendagRepository extends JpaRepository<ProdutoVenda, Long>{
    
}
