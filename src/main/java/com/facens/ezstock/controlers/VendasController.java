package com.facens.ezstock.controlers;

import java.net.URI;
import java.util.List;

import com.facens.ezstock.entities.dto.ProdutoDto;
import com.facens.ezstock.services.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
	public ResponseEntity<ProdutoDto> inserirProdutoVenda(@RequestBody ProdutoDto produtoDto){
		ProdutoDto dto = vendaService.inserir(produtoDto); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerProdutoVenda(@PathVariable Long id) { 
		vendaService.remover(id);
        return ResponseEntity.noContent().build();
	}

    //BUSCA TODOS PRODUTOS CADASTRADOS EM VENDA
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> listar(){ 
        List<ProdutoDto> listDto = vendaService.buscarTodos();
        return ResponseEntity.ok().body(listDto);
	}
    
}
