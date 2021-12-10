package br.com.pastelaria.empresa;

import java.sql.Connection;
import br.com.pastelaria.compartilhado.*;

public class PrincipalEmpresa{
	public static Connection conexao;

	public static void main(String[] args) {
		conexao = Conexao.getConnection();

		if (conexao == null) System.exit(1);

		LoginGenerico login = new LoginGenerico("Empresa");
		
		if (login.logar() == 0) {
			Conexao.closeConnection(conexao);
			System.exit(0);
		}
	}
}
