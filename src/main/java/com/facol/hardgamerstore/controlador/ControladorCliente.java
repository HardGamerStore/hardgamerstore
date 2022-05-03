package com.facol.hardgamerstore.controlador;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.RepositorioCliente;
import com.facol.hardgamerstore.modelo.Cliente;

@SuppressWarnings("serial")
@SessionScoped
@Named("controladorCliente")
public class ControladorCliente implements Serializable {

	@Inject
	private RepositorioCliente repCliente;
	private List<Cliente> clientes;
	
	
	private int id;
	private String nomeCliente;
	private String cpf;
	private String email;
	private String dataDeNascimento;
	
	private String login;
	private String senha;
	
	private String telefone;

	private String genero;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	
	public String cadastrar() {
	
		Cliente cliente = new Cliente();
		cliente.setId(this.id);
		cliente.setNome(this.nomeCliente);
		cliente.setCpf(this.cpf);
		cliente.setEmail(this.email);
		cliente.setDataDeNascimento(this.dataDeNascimento);
		cliente.setLogin(this.login);
		cliente.setSenha(this.senha);
		cliente.setTelefone(this.telefone);
		cliente.setGenero(this.genero);
		cliente.setEstado(this.estado);
		cliente.setCidade(this.cidade);
		cliente.setBairro(this.bairro);
		cliente.setLogradouro(this.logradouro);
		
		this.repCliente.criar(cliente);
		this.listar();
		return "listaClientes.xhtml";
		
	}
	
	public void listar(){
		this.clientes = repCliente.listar();
	}
	
	public String remover(Cliente cliente) {
		this.repCliente.remover(cliente);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente removido com sucesso", ""));
		this.listar();
		return null;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
