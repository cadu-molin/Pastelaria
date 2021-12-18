package br.com.pastelaria.empresa;

import java.sql.Connection;
import br.com.pastelaria.compartilhado.*;

public class PrincipalEmpresa {
	public static Connection conexao;

	public static void main(String[] args) {
		Integer opcao;
		Menus menuPrincipal = new Menus(false);
		conexao = Conexao.getConnection();

		if (conexao == null) System.exit(1);

		//Intancia o Login
		LoginGenerico login = new LoginGenerico("Empresa");

		if (login.logar() == 0) {
			Conexao.closeConnection(conexao);
			System.exit(0);
		}
		
		do {
			opcao = menuPrincipal.menuPrincipal();

			switch (opcao) {
			case 1:
				//opcao = this.logando(); Deveria mostrar e alterar o produto
				System.exit(0);
				break;
			case 2:
				//opcao = this.cadastrando(); Deveria mostrar os pedidos
				System.exit(0);
				break;
			case 3:
				//opcao = this.cadastrando(); Deveria mostrar ou alterar a empresa empresa
				System.exit(0);
				break;
			case 0:
				System.exit(0); //Aqui fecha o programa
				//return 0;
			default:
				System.out.println("Tecla inválida. Favor informar outra!\r\n");
			}
		} while (opcao > 3 || opcao < 0);
	}
}
