package br.com.weblivraria.dao;

public interface CRUDUsuario<T> extends CRUDLivraria<T> {
	boolean login(T dados);
	String alterarSenha(T dados);

}
