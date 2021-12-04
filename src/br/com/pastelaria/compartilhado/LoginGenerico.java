package br.com.pastelaria.compartilhado;

public class LoginGenerico {
	Boolean isCliente;
	Integer opcao;
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
					opcao = 1;
					break;
				case 2:
					opcao = 1;
					break;
				case 3:
					opcao = 1;
					break;
				case 0:
					opcao = 1;
					break;
				default:
					System.out.println("Tecla inválida. Favor informar outra!\r\n");
			}
		} while (opcao > 3 || opcao < 0);
		return 1;
	}
}
