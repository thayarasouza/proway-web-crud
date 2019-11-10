package br.com.prowayweb.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.prowayweb.data.ConexaoJDBC;
import br.com.prowayweb.data.ConexaoJDBCMySql;
import br.com.prowayweb.model.Usuario;

public class UsuarioService {

	private final ConexaoJDBC conexao;
	private String sqlQuery;
	private PreparedStatement stmt;
	private ResultSet rs;

	public UsuarioService() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBCMySql();
	}

	public List<Usuario> listarTodosUsuario() throws SQLException, ClassNotFoundException {
		sqlQuery = "SELECT * FROM usuario ORDER BY id";

		try {
			stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			rs = stmt.executeQuery();

			List<Usuario> usuarios = new ArrayList<>();

			while (rs.next()) {
				usuarios.add(parser(rs));
			}

			return usuarios;
		} catch (SQLException sqlError) {
			throw sqlError;
		}
	}

	private Usuario parser(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario(rs.getLong("id"), rs.getString("nome"));
		return usuario;
	}
}