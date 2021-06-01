package com.facens.ezstock.controlers;

import java.util.List;

import com.facens.ezstock.entities.dto.ProdutoDto;
import com.facens.ezstock.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
	private ProdutoService produtoService;
	
	@PutMapping("{id}")
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
		ProdutoDto dto = produtoService.atualizar(id, produtoDto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) { 
		produtoService.remover(id);
        return ResponseEntity.noContent().build();
	}

    @GetMapping
	public ResponseEntity<List<ProdutoDto>> listar(){ 
        List<ProdutoDto> listDto = produtoService.buscarTodos();
        return ResponseEntity.ok().body(listDto);
	}

    @GetMapping("{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Long id){
        ProdutoDto dto = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    //BUSCA POR CODIGO PRODUTO
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<List<ProdutoDto>> buscarPorCodigo(@PathVariable String codigo){
        List<ProdutoDto> dto = produtoService.buscarPorCodigo(codigo);
        return ResponseEntity.ok().body(dto);
    }

    //BUSCA PRODUTOS POR NOME
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ProdutoDto>> buscarPorNome(@PathVariable String nome){
        List<ProdutoDto> listDto = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok().body(listDto);
    }

    //BUSCA PRODUTOS POR CATEGORIA
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProdutoDto>> buscarPorCategoria(@PathVariable String categoria){
        List<ProdutoDto> listDto = produtoService.buscarPorCategoria(categoria);
        return ResponseEntity.ok().body(listDto);
    }
}
