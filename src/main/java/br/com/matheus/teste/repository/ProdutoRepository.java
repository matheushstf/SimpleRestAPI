package br.com.matheus.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheus.teste.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Optional<Produto> findById(Long id); 

}
