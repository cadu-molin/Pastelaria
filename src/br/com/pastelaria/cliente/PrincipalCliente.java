package br.com.pastelaria.cliente;

import java.sql.Connection;
import br.com.pastelaria.compartilhado.*;


public class PrincipalCliente {
	static Connection conexao;

	public static void main(String[] args) {
		conexao = Conexao.getConnection();
		
		if (conexao == null) {
			System.exit(0);
		}
	}
}
