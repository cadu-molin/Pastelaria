package br.com.pastelaria.compartilhado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
	Scanner scan = new Scanner(System.in);

	public Integer menuLogin() {

		System.out.println("=======================");
		System.out.println("==== MENU DO LOGIN ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");
		System.out.println("=======================");

		return getInteger();
	}

	public Integer menuCliente(String nomeUsuario) {
		System.out.println("==== MENU DO USUÁRIO: " + nomeUsuario + " ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");

		return getInteger();
	}

	public Integer menuEmpresa(String nomeFuncionario) {
		System.out.println("==== MENU DO FUNCIONARIO: " + nomeFuncionario + " ====");
		System.out.println("[1] - Logar");
		System.out.println("[2] - Cadastrar-se");
		System.out.println("[0] - Sair do Sistema");

		return getInteger();
	}

	private Integer getInteger() {
		Integer opcao;
		
		try {
			opcao = scan.nextInt();
			
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
