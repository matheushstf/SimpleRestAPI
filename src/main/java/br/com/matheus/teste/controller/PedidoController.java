package br.com.matheus.teste.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.matheus.teste.controller.form.AtualizacaoPedidoForm;
import br.com.matheus.teste.model.Produto;
import br.com.matheus.teste.repository.ProdutoRepository;

@RequestMapping("/api")
@RestController
public class PedidoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listagem(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> buscaProduto(@PathVariable Long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping
	public Produto adiciona(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public List<Produto> remove(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return produtoRepository.findAll();
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoPedidoForm pedidoForm){
		Produto produto = pedidoForm.atualizar(id, produtoRepository);
		return ResponseEntity.ok(produto);
	}
}
