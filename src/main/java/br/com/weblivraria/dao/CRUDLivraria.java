package br.com.weblivraria.dao;

import java.util.List;

public interface CRUDLivraria<T> {
	String cadastrar(T dados);
	List <T> listar();
	T pesquisar(T dados);
	String atualizar(T dados);
	String apagar(Integer id);
		

}
