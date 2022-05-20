package com.facol.hardgamerstore.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import com.facol.hardgamerstore.dados.RepositorioCategoria;
import com.facol.hardgamerstore.dados.RepositorioProduto;
import com.facol.hardgamerstore.modelo.Categoria;
import com.facol.hardgamerstore.modelo.Produto;


@SuppressWarnings("serial")
@SessionScoped
@Named("controladorProduto")
public class ControladorProduto implements Serializable {

	@Inject
	private RepositorioProduto repProduto;
	@Inject
	private RepositorioCategoria catRepositorio;
	private List<Produto> produtos;
	private String descricao, unidadeDeMedida,caracteristica;
    private int estoque;
    private double precoDeCusto,precoDeVenda; 
    private Categoria categoria;
    private Long categoriaId;
    private Long id;
    

	Produto produto;
    
    
    //upload de imagens
  //DIRETORIO ONDE SÃO SALVA AS IMAGENS (obs.: CONFIRAM COM ATENÇÃO O DIRETORIO )
    private String folder = "C:/Users/GTXGu/workspace-facol/hardgamerstore/src/main/webapp/resources/imagens/";
	private Part uploadedFile;
	private String nomeArquivo;
	
	
	//METODO PARA SALVAR IMAGEM
		public void saveFile() {

		String fileName = "";
				 
			  try {
				  
				  fileName = getFilename(uploadedFile);
				  
				  uploadedFile.write(folder+fileName);		  
		            
		        } catch (IOException ex) {
		            System.out.println(ex);      
		        }
			  //MENSAGEM DE UPLOAD CONCLUIDO
			  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("IMAGEM " + fileName+ " IMAGEM SALVA COM SUCESSO!"));
		}
		
		//RECEBE A IMAGEM
		private static String getFilename(Part part) {
	        for (String cd : part.getHeader("content-disposition").split(";")) {
	            if (cd.trim().startsWith("filename")) {
	                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	            }
	        }
	        return null;
	    }
    
		
	public String painel() {
		return "/restrito/painel.xhtml?faces-redirect=true";
	}
    
	public String cadastrar() {

		Produto produto = new Produto();
		produto.setEstoque(estoque);
		produto.setPrecoDeCusto(precoDeCusto);
		produto.setPrecoDeVenda(precoDeVenda);
		//SALVA O NOME DA IMAGEM NO BANCO DE DADOS 
		produto.setNomeArquivo(this.uploadedFile.getSubmittedFileName());
		
		if (this.categoriaId != null) {
			Categoria categoria = this.catRepositorio.encontrarPorId(this.categoriaId);
			produto.setCategoriaId(categoria);
		}

		produto.setCaracteristica(caracteristica);		
		produto.setDescricao(this.descricao);
		produto.setUnidadeDeMedida(this.unidadeDeMedida);
		
		
		this.saveFile();
		this.repProduto.criar(produto);
		return "/restrito/produtoListar.xhtml?faces-redirect=true";
	}
	
	public String alterar() {

		Produto produto = new Produto();
		produto.setEstoque(estoque);
		produto.setPrecoDeCusto(precoDeCusto);
		produto.setPrecoDeVenda(precoDeVenda);
		produto.setNomeArquivo(this.uploadedFile.getSubmittedFileName());
		
		if (this.categoriaId != null) {
			Categoria categoria = this.catRepositorio.encontrarPorId(this.categoriaId);
			produto.setCategoriaId(categoria);
		}

		produto.setCaracteristica(caracteristica);		
		produto.setDescricao(this.descricao);
		produto.setUnidadeDeMedida(this.unidadeDeMedida);
		
		this.repProduto.alterar(produto);
		this.repProduto.listar();
		return "/restrito/produtoListar.xhtml?faces-redirect=true";
	}
	
	
	public String encontrarPorId(Long idProduto) {

		produto = this.repProduto.encontrarPorId(idProduto);
		estoque = this.produto.getEstoque();
		precoDeCusto = this.produto.getPrecoDeCusto();
		precoDeVenda = this.produto.getPrecoDeVenda();
		nomeArquivo = this.produto.getNomeArquivo();
		caracteristica = this.produto.getCaracteristica();
		descricao = this.produto.getDescricao();
		unidadeDeMedida = this.produto.getUnidadeDeMedida();
		
		return "/restrito/produtoAlterar.xhtml?faces-redirect=true";
}
	
	public void limpar() {
		this.descricao = null;
		this.unidadeDeMedida = null;
	}
	
public List<Produto> listar() {
		
		this.produtos=repProduto.listar();
		
		return produtos;
		
	}
	
	public String remover(Produto produto) {
		this.repProduto.remover(produto);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto removido com sucesso", ""));
		this.listar();
		return null;
	}
	
	public List<SelectItem> listarCategorias() {
		List<SelectItem> result = new ArrayList<SelectItem>();
		List<Categoria> categorias = this.catRepositorio.listar();
		if (categorias != null && !categorias.isEmpty()) {
			for (Categoria categoria : categorias) {
				result.add(new SelectItem(categoria.getId(), categoria.getNome()));
			}
		}
		return result;
	}
	
	
	
	public RepositorioProduto getRepProduto() {
		return repProduto;
	}
	public void setRepProduto(RepositorioProduto repProduto) {
		this.repProduto = repProduto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	
	
	
}
