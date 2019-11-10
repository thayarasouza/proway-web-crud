package br.com.prowayweb.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoJDBCMySql implements ConexaoJDBC {

	
	private Connection connection = null;

	// usuario do banco
	private static final String USERNAME = "root";

	// Senha do usuario adm
	private static final String PASSWORD = "123456";

	// Dados de caminho, porta e nome da base de dados que ir� ser feita a conex�o
	private static final String DATABASE_URL = "jdbc:mysql://0.0.0.0:3306/proway_web?useTimezone=true&serverTimezone=UTC";

	public ConexaoJDBCMySql() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		this.connection.setAutoCommit(false);
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

	@Override
	public void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoJDBCMySql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

	@Override
	public void commit() throws SQLException {
		this.connection.commit();
		this.close();
	}

	@Override
	public void rollback() {
		if (this.connection != null) {
			try {
				this.connection.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoJDBCMySql.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				this.close();
			}
		}

	}
}