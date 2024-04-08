package br.com.weblivraria.dominio;

public class Livro {
	private Integer idlivro;
	private String titulo;
	private String genero;
	private String sinopse;
	private String autor;
	private Double preco;
	private String capa;
	
	public Integer getIdlivro() {
		return idlivro;
	}
	public void setIdlivro(Integer idlivro) {
		this.idlivro = idlivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}

}
