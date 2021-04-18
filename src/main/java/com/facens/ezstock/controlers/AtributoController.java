package com.facens.ezstock.controlers;

import java.net.URI;
import java.util.List;

import com.facens.ezstock.entities.dto.AtributoDto;
import com.facens.ezstock.services.AtributoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/atributo")
public class AtributoController {

    @Autowired
	private AtributoService atributoService;

    @PostMapping
	public ResponseEntity<AtributoDto> criar(@RequestBody AtributoDto atributoDto){
		AtributoDto dto = atributoService.criar(atributoDto); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AtributoDto> atualizar(@PathVariable Long id, @RequestBody AtributoDto atributoDto) {
		AtributoDto dto = atributoService.atualizar(id, atributoDto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) { 
		atributoService.remover(id);
        return ResponseEntity.noContent().build();
	}

    //BUSCA TODOS ATRIBUTOS CADASTRADOS
	@GetMapping
	public ResponseEntity<List<AtributoDto>> listar(){ 
        List<AtributoDto> listDto = atributoService.buscarTodos();
        return ResponseEntity.ok().body(listDto);
	}

    //BUSCA POR ID
    @GetMapping("{id}")
    public ResponseEntity<AtributoDto> buscarPorId(@PathVariable Long id){
        AtributoDto dto = atributoService.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    //BUSCA PRODUTOS POR NOME
    @GetMapping("/nome={nome}")
    public ResponseEntity<List<AtributoDto>> buscarPorNome(@PathVariable String nome){
        List<AtributoDto> listDto = atributoService.buscarPorNome(nome);
        return ResponseEntity.ok().body(listDto);
    }

}
