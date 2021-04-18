package com.facens.ezstock.entities.dto;

import com.facens.ezstock.entities.Atributo;

public class AtributoDto {

    private Long id;
    private String nome;
    
    public AtributoDto() {
    }

    public AtributoDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public AtributoDto(Atributo atributo) {
        setId(atributo.getId());
        setNome(atributo.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
