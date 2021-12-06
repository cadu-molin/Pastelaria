package br.com.pastelaria.compartilhado;

import java.util.Scanner;

public class Menus {
	Scanner scan = new Scanner(System.in);

	public Integer menuLogin(Boolean isCliente) {
		Integer opcao;
		
		System.out.println("=======================");
		System.out.println("==== MENU DO LOGIN ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		
		if (isCliente) {
			System.out.println("[3] - Entrar como Visitante");
		}
		
		System.out.println("[0] - Sair do Sistema");
		System.out.println("=======================");
		
		opcao = scan.nextInt();
		
		this.limparTela();
		
		return opcao;
	}

	public Integer menuCliente(String nomeUsuario) {
		Integer opcao;
		
		System.out.println("==== MENU DO USUÁRIO: " + nomeUsuario + " ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");
		
		opcao = scan.nextInt();
		
		this.limparTela();
		
		return opcao;
	}

	public Integer menuEmpresa(String nomeFuncionario) {
		Integer opcao;
		
		System.out.println("==== MENU DO FUNCIONARIO: " + nomeFuncionario + " ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");
		
		opcao = scan.nextInt();
		
		this.limparTela();
		
		return opcao;
	}
	
	public void limparTela() {
		for (int x = 1; x < 100; x++) {
			System.out.println();
		}
	}
}
