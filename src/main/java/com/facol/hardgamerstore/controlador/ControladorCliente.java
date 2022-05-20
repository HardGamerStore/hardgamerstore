package com.facol.hardgamerstore.controlador;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.facol.hardgamerstore.dados.RepositorioCliente;
import com.facol.hardgamerstore.modelo.Cliente;

@SuppressWarnings("serial")
@Named("controladorCliente")
@SessionScoped
@ManagedBean
public class ControladorCliente implements Serializable {

	@Inject
	private RepositorioCliente repCliente;
	private List<Cliente> clientes;
	Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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

	public String cadastrar() {

		if (this.cpf != null) {

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
			limparCampos();
			
		}
		return "/login.xhtml?faces-redirect=true";
	}
	
	public void limparCampos() {
		this.cpf = null;
	}
	
	public String telaLogin() {
		return "/login.xhtml?faces-redirect=true";
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

		return "/restrito/formAlterarCliente.xhtml?faces-redirect=true";
	}

	public String alterar() {
		cliente.setNome(this.cliente.getNome());
		cliente.setCpf(this.cliente.getCpf());
		cliente.setEmail(this.cliente.getEmail());
		cliente.setDataDeNascimento(this.cliente.getDataDeNascimento());
		cliente.setLogin(this.cliente.getLogin());
		cliente.setSenha(this.cliente.getSenha());
		cliente.setTelefone(this.cliente.getTelefone());
		cliente.setGenero(this.cliente.getGenero());
		cliente.setEstado(this.cliente.getEstado());
		cliente.setCidade(this.cliente.getCidade());
		cliente.setBairro(this.cliente.getBairro());
		cliente.setLogradouro(this.cliente.getLogradouro());

		this.repCliente.alterar(cliente);
		return "/index.xhtml?faces-redirect=true";
	}

	public String login() {

		cliente = repCliente.validate(login, senha);
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(login == null && senha == null) {
			return null;
		} else {
			context.getExternalContext().getSessionMap().put("cliente", cliente);
			return "/index.xhtml?faces-redirect=true";
		}
	}
	
	public String logOut() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	            .getExternalContext().getSession(false);
	    session.invalidate();
	    
	    return "/index.xhtml?faces-redirect=true";
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
		return "/restrito/listaClientes.xhtml?faces-redirect=true";
	}

	public void msgUpdate() {
		addMessage("Alterar cliente", "Redirecionando para o formulário...");
	}

	public void msgDelete() {
		Cliente c = new Cliente();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Deletar",
				"Cliente " + c.getNome() + " excluído com sucesso.");
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
