package com.facens.ezstock.controlers;

import java.net.URI;
import java.util.List;

import com.facens.ezstock.entities.dto.ProdutoEstoqueDTO;
import com.facens.ezstock.entities.dto.ProdutoInsertEstoqueDTO;
import com.facens.ezstock.entities.dto.ProdutoUpdateEstoqueDTO;
import com.facens.ezstock.services.ProdutoEstoqueService;

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
@RequestMapping("/estoque")
public class ProdutoEstoqueController {

    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

	//instancia um produto e adiciona ao estoque
	@PostMapping
	public ResponseEntity<ProdutoEstoqueDTO> criar(@RequestBody ProdutoInsertEstoqueDTO produtoInsertEstoqueDTO){
		ProdutoEstoqueDTO dto = produtoEstoqueService.inserir(produtoInsertEstoqueDTO); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoEstoqueDTO>> listar(){ 
		List<ProdutoEstoqueDTO> listDto = produtoEstoqueService.buscarTodos();
		return ResponseEntity.ok().body(listDto);
	}

	//altera quantidade de produto em estoque
	@PutMapping("{id}")
	public ResponseEntity<ProdutoEstoqueDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoUpdateEstoqueDTO produtoUpdateDto) {
		ProdutoEstoqueDTO dto = produtoEstoqueService.atualizar(id, produtoUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> removerProdutodoEstoque(@PathVariable Long id) { 
		produtoEstoqueService.remover(id);
        return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<ProdutoEstoqueDTO> buscarPorId(@PathVariable Long id){
		ProdutoEstoqueDTO dto = produtoEstoqueService.buscarPorId(id);
		return ResponseEntity.ok().body(dto);
	}
}
