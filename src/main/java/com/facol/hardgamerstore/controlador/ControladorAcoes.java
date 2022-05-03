package com.facol.hardgamerstore.controlador;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SuppressWarnings("serial")
@SessionScoped
@Named("controladorAcoes")
public class ControladorAcoes implements Serializable {
	
	public String voltarParaHome() {
		return "index.xhtml";
	}
	
	public String listaDeClientes() {
		return "listaClientes.xhtml";
	}
	
	public String formCadastroDeClientes() {
		return "formCadastroCliente.xhtml";
	}
	

}
