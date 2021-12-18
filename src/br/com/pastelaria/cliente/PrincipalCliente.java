package br.com.pastelaria.cliente;

import java.sql.Connection;
import br.com.pastelaria.compartilhado.*;

public class PrincipalCliente {
	public static Connection conexao;

	public static void main(String[] args) {
		Integer opcao;
		Menus menuPrincipal = new Menus(true);
		conexao = Conexao.getConnection();

		if (conexao == null) System.exit(1);
		
		//Intancia o Login
		LoginGenerico login = new LoginGenerico("Cliente");

		if (login.logar() == 0) {
			Conexao.closeConnection(conexao);
			System.exit(0);
		}
		
		do {
			opcao = menuPrincipal.menuPrincipal();

			switch (opcao) {
			case 1:
				//opcao = this.logando(); Deveria mostrar o(s) produto(s) e fazer o pedido
				System.exit(0);
				break;
			case 2:
				//opcao = this.cadastrando(); Deveria mostra o pedido
				System.exit(0);
				break;
			case 0:
				System.exit(0);//Aqui fecha o programa
				//return 0;
			default:
				System.out.println("Tecla inválida. Favor informar outra!\r\n");
			}
		} while (opcao > 2 || opcao < 0);
	}
}
