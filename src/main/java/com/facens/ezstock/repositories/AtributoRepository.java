package com.facens.ezstock.repositories;

import java.util.List;

import com.facens.ezstock.entities.Atributo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtributoRepository extends JpaRepository<Atributo, Long>{

    List<Atributo> findByNomeContainingIgnoreCase(String nome);
    
}
