package com.facens.ezstock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.ezstock.entities.Atributo;
import com.facens.ezstock.entities.dto.AtributoDto;
import com.facens.ezstock.repositories.AtributoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AtributoService {

    @Autowired
    private AtributoRepository atributoRepository;

    private String msgNotFound = "Produto não encontrado";
    
    public AtributoDto criar(AtributoDto atributoDto) {
        Atributo atributo = new Atributo(atributoDto);
        return new AtributoDto(atributoRepository.save(atributo));
    }

    public AtributoDto atualizar(Long id, AtributoDto atributoDto) { 
        try {
            Atributo atributo = atributoRepository.getOne(id);
            //não seta valores Null que vieram do DTO
            if(atributoDto.getNome() != null) {
                atributo.setNome(atributoDto.getNome());
            }

            atributo = atributoRepository.save(atributo);
            return new AtributoDto(atributo);

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public void remover(Long id) {
        try {
            atributoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
        }
    }

    public List<AtributoDto> buscarTodos() {
		List<Atributo> atributosEncontrados = atributoRepository.findAll();
        if (atributosEncontrados.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listAtributoDto(atributosEncontrados);
	}

    public AtributoDto buscarPorId(Long id) {
        Optional<Atributo> op = atributoRepository.findById(id);
        Atributo atributo = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound));
        return new AtributoDto(atributo);
    }

    public List<AtributoDto> buscarPorNome(String nome) {
		List<Atributo> produtosEncontrados = atributoRepository.findByNomeContainingIgnoreCase(nome);
        if (produtosEncontrados == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, msgNotFound);
		}
        return listAtributoDto(produtosEncontrados);
	}

    private List<AtributoDto> listAtributoDto(List<Atributo> atributos){
        List<AtributoDto> listAtributoDto = new ArrayList<>();
        for (Atributo atributo : atributos) {
            AtributoDto atributoDto = new AtributoDto(atributo);
            listAtributoDto.add(atributoDto);
        }
        return listAtributoDto;
    }

}
