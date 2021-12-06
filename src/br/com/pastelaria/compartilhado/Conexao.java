package br.com.pastelaria.compartilhado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/CURSO";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "1";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
			return null;
		}
	}

	public static void closeConnection(Connection conexao) {
		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao fechar o banco de dados!");
			e.printStackTrace();
		}
	}
}
