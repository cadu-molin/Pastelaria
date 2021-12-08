package br.com.pastelaria.compartilhado;

import java.util.Scanner;

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
		System.out.println("Olá, seja bem vindo a Pastelaria \r\n");
		
		do {
			opcao = menulogin.menuLogin(isCliente);
			
			switch (opcao){
				case 1:
					this.login();
					break;
				case 2:
					opcao = 2;
					break;
				case 3:
					opcao = 3;
					break;
				case 0:
					return 0;
			default:
					System.out.println("Tecla inválida. Favor informar outra!\r\n");
			}
		} while (opcao > 3 || opcao < 0);
		return 1;
	}
	
	private Integer login() {
		Integer contador = 0;
		
		do {
			System.out.println("========= LOGIN =========");
			System.out.println("Digite o nome do usuário: ");
			usuario = scan.next();
			
			System.out.println("Digite sua senha: ");
			senha = scan.next();
			
//			if (confereLogin(usuario, senha)) {
//				
//			}
			
			contador += 1;
		} while (contador > 0);
		return 1;
	}
	
	private boolean confereLogin(Object usuario, Object senha) {
		//String 
		return true;
	}
}
