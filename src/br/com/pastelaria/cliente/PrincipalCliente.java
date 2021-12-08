package br.com.pastelaria.cliente;

import java.sql.Connection;
import br.com.pastelaria.compartilhado.*;


public class PrincipalCliente {
	static Connection conexao;

	public static void main(String[] args) {
		conexao = Conexao.getConnection();
		
		if (conexao == null) System.exit(1);
		
		LoginGenerico login = new LoginGenerico("Cliente");
		
		if (login.logar() == 0) {
			Conexao.closeConnection(conexao);
			System.exit(0);
		}
	}
}
