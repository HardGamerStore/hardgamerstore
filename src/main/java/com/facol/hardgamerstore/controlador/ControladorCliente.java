package com.facol.hardgamerstore.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.RepositorioCliente;
import com.facol.hardgamerstore.modelo.Cliente;

@SuppressWarnings("serial")
@RequestScoped
@Named("controladorCliente")
public class ControladorCliente implements Serializable {

	@Inject
	private RepositorioCliente repCliente;
	private List<Cliente> clientes;
	Cliente cliente;

	private Long id;
	private String nomeCliente;
	private String cpf;
	private String email;
	private String dataDeNascimento;
	private String genero;
	private String telefone;
	
	private String login;
	private String senha;
	
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;

	public String cadastrar() throws IOException {
		Cliente c = new Cliente();
		c.setId(this.id);
		c.setNome(this.nomeCliente);
		c.setCpf(this.cpf);
		c.setEmail(this.email);
		c.setDataDeNascimento(this.dataDeNascimento);
		c.setLogin(this.login);
		c.setSenha(this.senha);
		c.setTelefone(this.telefone);
		c.setGenero(this.genero);
		c.setEstado(this.estado);
		c.setCidade(this.cidade);
		c.setBairro(this.bairro);
		c.setLogradouro(this.logradouro);

		this.repCliente.criar(c);
		FacesContext.getCurrentInstance().getExternalContext().dispatch("/cliente/listaClientes.xhtml");
		return null;
	}
	
	public String encontrarPorId(Long idCliente) {

		cliente = this.repCliente.encontrarPorId(idCliente);
		nomeCliente = this.cliente.getNome();
		cpf = this.cliente.getCpf();
		email = this.cliente.getEmail();
		dataDeNascimento = this.cliente.getDataDeNascimento(); 
		login = this.cliente.getLogin();
		senha = this.cliente.getSenha();
		telefone = this.cliente.getTelefone();
		genero = this.cliente.getGenero();
		estado = this.cliente.getEstado();
		cidade = this.cliente.getCidade();
		bairro = this.cliente.getBairro();
		logradouro = this.cliente.getLogradouro();
		
		return "/cliente/formAlterarCliente.xhtml";
}
	
	public String alterar() {
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
		
		this.repCliente.alterar(cliente);
		return "/cliente/listaClientes.xhtml";
	}

	public List<Cliente> listar() {
		this.clientes = repCliente.listar();
		return clientes;
	}

	public String remover(Cliente cliente) {
		this.repCliente.remover(cliente);
		this.listar();
		return null;
	}
	
	public String listaDeClientes() {
		return "/cliente/listaClientes.xhtml";
	}
	
	public void msgUpdate() {
        addMessage("Alterar cliente", "Redirecionando para o formulário...");
    }

    public void msgDelete() {
    	Cliente c = new Cliente();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, 
        		"Deletar", "Cliente "+c.getNome() + " excluído com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
