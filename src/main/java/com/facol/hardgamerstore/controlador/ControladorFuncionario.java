package com.facol.hardgamerstore.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.facol.hardgamerstore.dados.RepositorioFuncionario;
import com.facol.hardgamerstore.modelo.Funcionario;

@SuppressWarnings("serial")
@Named("controladorFuncionario")
@SessionScoped
@ManagedBean
public class ControladorFuncionario implements Serializable{
	
	@Inject
	private RepositorioFuncionario repFuncionario;
	Funcionario funcionario = new Funcionario();
	
	private String login;
	private String senha;
	

	public String login() {

		funcionario = repFuncionario.validate(login, senha);
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(login == null && senha == null) {
			return null;
		} else {
			context.getExternalContext().getSessionMap().put("funcionario", funcionario);
			return "/restrito/painel?faces-redirect=true";
		}
	}
	
	public String logOut() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	            .getExternalContext().getSession(false);
	    session.invalidate();
	    
	    return "/index.xhtml?faces-redirect=true";
	}
	
	public String telaLogin() {
		return "/restrito/login.xhtml?faces-redirect=true";
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public RepositorioFuncionario getRepFuncionario() {
		return repFuncionario;
	}

	public void setRepFuncionario(RepositorioFuncionario repFuncionario) {
		this.repFuncionario = repFuncionario;
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
	

}
