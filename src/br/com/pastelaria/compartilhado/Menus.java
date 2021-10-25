package br.com.pastelaria.compartilhado;

import java.util.Scanner;

public class Menus {
	Scanner scan = new Scanner(System.in);

	public Integer menuLogin(Boolean isCliente) {
		System.out.println("== MENU DO LOGIN ===");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		if (isCliente) {
			System.out.println("[3] - Entrar como Visitante");
		}
		System.out.println("[0] - Sair do Sistema");

		return scan.nextInt();
	}

	public Integer menuCliente(String nomeUsuario) {
		System.out.println("== MENU DO USUÁRIO: " + nomeUsuario + "===");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");

		return scan.nextInt();
	}

	public Integer menuEmpresa(String nomeFuncionario) {
		System.out.println("== MENU DO FUNCIONARIO: " + nomeFuncionario + " ===");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");

		return scan.nextInt();
	}
}
