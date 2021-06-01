package com.facens.ezstock.controlers;

import java.net.URI;
import java.util.List;

import com.facens.ezstock.entities.dto.ProdutoVendaDTO;
import com.facens.ezstock.services.ProdutoVendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/venda")
public class ProdutoVendaController {

    @Autowired
    private ProdutoVendaService produtoVendaService;

	//instancia um produto e adiciona ao estoque
	@PostMapping("{id}/qtd={qtd}")
	public ResponseEntity<ProdutoVendaDTO> criar(@PathVariable Long id, @PathVariable Integer qtd){
		ProdutoVendaDTO dto = produtoVendaService.inserir(id, qtd); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoVendaDTO>> listar(){ 
		List<ProdutoVendaDTO> listDto = produtoVendaService.buscarTodos();
		return ResponseEntity.ok().body(listDto);
	}

	//altera quantidade de produto em venda
	@PutMapping("{id}/qtd={qtd}")
	public ResponseEntity<ProdutoVendaDTO> atualizar(@PathVariable Long id, @PathVariable Integer qtd) {
		ProdutoVendaDTO dto = produtoVendaService.atualizar(id, qtd);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> removerProdutodoVenda(@PathVariable Long id) { 
		produtoVendaService.remover(id);
        return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<ProdutoVendaDTO> buscarPorId(@PathVariable Long id){
		ProdutoVendaDTO dto = produtoVendaService.buscarPorId(id);
		return ResponseEntity.ok().body(dto);
	}
}
