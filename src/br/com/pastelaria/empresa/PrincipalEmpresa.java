package br.com.pastelaria.empresa;

import java.sql.Connection;
import br.com.pastelaria.compartilhado.*;

public class PrincipalEmpresa {
	Connection conexao;

	public static void main(String[] args) {
		Integer retorno;
		LoginGenerico login = new LoginGenerico("Cliente");
		// Menus menuLogin = new Menus();
		retorno = login.logar();

		System.out.println("Retorno: " + retorno);
	}
}
