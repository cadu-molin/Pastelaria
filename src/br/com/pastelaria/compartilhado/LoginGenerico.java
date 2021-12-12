package br.com.pastelaria.compartilhado;

import br.com.pastelaria.cliente.PrincipalCliente;
import br.com.pastelaria.empresa.PrincipalEmpresa;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LoginGenerico {
	private String usuario, senha;
	private Boolean isCliente;
	private Integer opcao;

	Scanner scan = new Scanner(System.in);
	Menus menulogin = new Menus();

	public LoginGenerico(String classe) {
		isCliente = classe.equalsIgnoreCase("CLIENTE");
	}

	public Integer logar() {
		do {
			opcao = menulogin.menuLogin();

			switch (opcao) {
			case 1:
				opcao = this.logando();
				break;
			case 2:
				opcao = this.cadastrando();
				break;
			case 0:
				return 0;
			default:
				System.out.println("Tecla inválida. Favor informar outra!\r\n");
			}
		} while (opcao > 2 || opcao < 0);
		return 1;
	}

	private Integer logando() {
		Integer contador = 0;
		CRUD crud;

		if (isCliente) {
			crud = new CRUD(PrincipalCliente.conexao);
		} else {
			crud = new CRUD(PrincipalEmpresa.conexao);
		}

		do {
			System.out.println("========= LOGIN =========");
			System.out.println("Digite o nome do usuário: ");
			usuario = scan.next();

			System.out.println("Digite sua senha: ");
			senha = scan.next();

			if (crud.validarLogin(this.parametroValidacao(usuario, senha)) == 2) {
				System.out.println("Login efetuado com sucesso!");
				menulogin.limparTela();
				contador = 0;
			} else {
				System.out.println("\n=======================================");
				System.out.println("====== Usuário ou senha inválido ======");
				System.out.println("\n=======================================");
				System.out.println("Deseja tentar novamente?\n[1] - Sim \n[0] - Não");
				if (scan.nextInt() == 1) {
					menulogin.limparTela();
					contador += 1;
				} else {
					return 3;
				}
			}
		} while (contador > 0);
		return 1;
	}

	private Map<String, String> parametroValidacao(String usuario, String senha) {
		String tipousuario;
		Map<String, String> atributo = new HashMap<String, String>();

		if (isCliente) {
			tipousuario = "C";
		} else {
			tipousuario = "F' OR TIPOUSUARIO = 'A";
		}

		atributo.put("TABELA", "USUARIO");
		atributo.put("CLAUSULA", "NOMEUSUARIO = '" + usuario + "' AND SENHA = '" + senha + "' AND (TIPOUSUARIO = '"
				+ tipousuario + "')");
		return atributo;
	}

	private Integer cadastrando() {
		Cadastro cadastro = new Cadastro(isCliente);
		
		if (cadastro.usuario() == 1) {
			return 2;
		} else {
			return 3;
		}
	}
}
