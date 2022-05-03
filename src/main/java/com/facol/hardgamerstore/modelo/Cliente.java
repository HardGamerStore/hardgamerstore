package com.facol.hardgamerstore.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {
	
	@Column(length = 150, nullable = false)
	private String email;
	@Column(length = 50, nullable = false)
	private String telefone;

	@Column(length = 200, nullable = false)
	private String estado;
	@Column(length = 200, nullable = false)
	private String cidade;
	@Column(length = 200, nullable = false)
	private String bairro;
	@Column(length = 200, nullable = false)
	private String logradouro;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}