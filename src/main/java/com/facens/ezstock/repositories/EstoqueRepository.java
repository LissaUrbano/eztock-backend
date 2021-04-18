package com.facens.ezstock.repositories;

import com.facens.ezstock.entities.Estoque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    

}
