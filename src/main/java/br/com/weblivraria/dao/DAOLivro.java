package br.com.weblivraria.dao;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.weblivraria.dominio.Livro;
 
public class DAOLivro extends Conexao implements CRUDLivraria<Livro> {
 
	@Override
	public String cadastrar(Livro dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "insert into livro(titulo,genero,sinopse,autor,preco,capa)values(?,?,?,?,?,?)";
				//preparar a consulta para a execução
				pst = con.prepareStatement(sql);
				//passagem dos parâmetros para a consulta
				pst.setString(1, dados.getTitulo());
				pst.setString(2, dados.getGenero());
				pst.setString(3, dados.getSinopse());
				pst.setString(4, dados.getAutor());
				pst.setDouble(5, dados.getPreco());
				pst.setString(6, dados.getCapa());
				if(pst.executeUpdate() > 0) {
					msg = "Cadastro realizado";
				}
				else {
					msg = "Não foi possível cadastrar";
				}
			}
			else msg = "Não foi possível estabelecer a conexão com o banco";
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}
 
	@Override
	public List<Livro> listar() {
		List<Livro> lista = new ArrayList<Livro>();
		try {
			if(abrirConexao()) {
				String sql = "Select * from livro order by idlivro desc";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					Livro liv = new Livro();
					liv.setIdlivro(rs.getInt(1));
					liv.setTitulo(rs.getString(2));
					liv.setGenero(rs.getString(3));
					liv.setSinopse(rs.getString(4));
					liv.setAutor(rs.getString(5));
					liv.setPreco(rs.getDouble(6));
					liv.setCapa(rs.getString(7));
					lista.add(liv);
				}
			}
			else {
				new Exception("Não foi possível estabelecer a conexão com o banco");
			}
		}
		catch(SQLException se) {
			new Exception("Erro na consulta "+se.getMessage());
		}
		catch(Exception e) {
			new Exception("Erro inesperado. "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return lista;
	}
 
	@Override
	public Livro pesquisar(Livro dados) {
		Livro liv = null;
		try {
			if(abrirConexao()) {
				String sql = "Select * from livros where idlivro=? or titulo=?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, dados.getIdlivro());
				pst.setString(2, dados.getTitulo());
				rs = pst.executeQuery();
				if(rs.next()) {
					liv = new Livro();
					liv.setIdlivro(rs.getInt(0));
					liv.setTitulo(rs.getString(1));
					liv.setGenero(rs.getString(2));
					liv.setSinopse(rs.getString(3));
					liv.setAutor(rs.getString(4));
					liv.setPreco(rs.getDouble(5));
					liv.setCapa(rs.getString(6));
				}
			}
			else {
				new Exception("Não foi possível estabelecer a conexão com o banco");
			}
		}
		catch(SQLException se) {
			new Exception("Erro na consulta "+se.getMessage());
		}
		catch(Exception e) {
			new Exception("Erro inesperado. "+e.getMessage());
		}
		finally {
			fecharConexao();
		}
		return liv;
	}
 
	@Override
	public String atualizar(Livro dados) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "update livro set titulo=?,genero=?,sinopse=?,preco=?,capa=? where idlivro=?";
				//preparar a consulta para a execução
				pst = con.prepareStatement(sql);
				//passagem dos parâmetros para a consulta
				pst.setString(1, dados.getTitulo());
				pst.setString(2, dados.getGenero());
				pst.setString(3, dados.getSinopse());
				pst.setDouble(4, dados.getPreco());
				pst.setString(5, dados.getCapa());
				pst.setInt(6, dados.getIdlivro());
				if(pst.executeUpdate() > 0) {
					msg = "Atualização realizado";
				}
				else {
					msg = "Não foi possível atualizar";
				}
			}
			else msg = "Não foi possível estabelecer a conexão com o banco";
		}
		catch(SQLException se) {
			msg = "Erro ao tentar atualizar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}
 
	@Override
	public String apagar(Integer id) {
		String msg = "";
		try {
			if(abrirConexao()) {
				String sql = "delete from livro where idlivro=?";
				//preparar a consulta para a execução
				pst = con.prepareStatement(sql);
				//passagem dos parâmetros para a consulta
				pst.setInt(1,id);
				if(pst.executeUpdate() > 0) {
					msg = "Apagado com sucesso";
				}
				else {
					msg = "Não foi possível apagar";
				}
			}
			else msg = "Não foi possível estabelecer a conexão com o banco";
		}
		catch(SQLException se) {
			msg = "Erro ao tentar apagar. "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharConexao();
		}
		return msg;
	}
 
}
