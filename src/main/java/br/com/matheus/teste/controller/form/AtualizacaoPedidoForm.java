package br.com.matheus.teste.controller.form;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.matheus.teste.model.Produto;
import br.com.matheus.teste.repository.ProdutoRepository;

public class AtualizacaoPedidoForm {

	private String nome;
	private BigDecimal valor;
	private int quantidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		produto.setNome(this.nome);
		produto.setQuantidade(this.quantidade);
		produto.setValor(this.valor);
		return produto;
	}

}
