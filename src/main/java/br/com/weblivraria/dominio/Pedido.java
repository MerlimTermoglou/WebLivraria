package br.com.weblivraria.dominio;

import java.sql.Date;

public class Pedido {
	private Integer idpedido;
	private Integer idusuario;
	private Date datahora;
	private Double totalpedido;
	
	
	public Integer getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public Date getDatahora() {
		return datahora;
	}
	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}
	public Double getTotalpedido() {
		return totalpedido;
	}
	public void setTotalpedido(Double totalpedido) {
		this.totalpedido = totalpedido;
	}
	

}
