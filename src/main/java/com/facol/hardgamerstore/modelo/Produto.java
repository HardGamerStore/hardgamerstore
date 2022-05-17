package com.facol.hardgamerstore.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int estoque;
	@Column(length = 200, nullable = false)
	private String descricao;
	@Column(length = 250, nullable = false)
	private String unidadeDeMedida;
	@Column(length = 250, nullable = false)
	private String caracteristica;
	@Column(nullable = false)
	private double precoDeCusto;
	@Column(nullable = false)
	private double precoDeVenda;
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoriaId;
	
	private String nomeArquivo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public double getPrecoDeCusto() {
		return precoDeCusto;
	}
	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}
	public double getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public Categoria getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Categoria categoria) {
		this.categoriaId = categoria;
	}
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	


}
