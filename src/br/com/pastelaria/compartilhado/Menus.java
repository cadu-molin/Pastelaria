package br.com.pastelaria.compartilhado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
	Scanner scan = new Scanner(System.in);
	Boolean isCliente;
	
	public Menus(Boolean isCliente) {
		this.isCliente = isCliente;
	}

	public Integer menuLogin() {

		System.out.println("=======================");
		System.out.println("==== MENU DO LOGIN ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");
		System.out.println("=======================");

		return getInteger();
	}

	public Integer menuPrincipal() {
		this.limparTela();
		
		if (isCliente) {
			System.out.println("==== MENU DO USUÁRIO ====");
		} else {
			System.out.println("==== MENU DO FUNCIONARIO ====");
		}
		
		System.out.println("[1] - Produtos");
		System.out.println("[2] - Pedidos");
		
		if (isCliente == false) {
			System.out.println("[3] - Dados da empresa");
		}
		
		System.out.println("[0] - Sair do Sistema");

		return getInteger();
	}

	private Integer getInteger() {
		Integer opcao;

		try {
			opcao = scan.nextInt();
			scan.nextLine();

			this.limparTela();

			return opcao;
		} catch (InputMismatchException ex) {
			System.out.println("Por favor, informe apenas valores numéricos.");
			return 10;
		}
	}

	public void limparTela() {
		for (int x = 1; x < 100; x++) {
			System.out.println();
		}
	}
}
