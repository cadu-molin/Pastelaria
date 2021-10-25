package br.com.pastelaria.compartilhado;

public class LoginGenerico {
	Boolean isCliente;
	Integer opcao;
	
	public LoginGenerico(String classe) {
		isCliente = classe.toUpperCase() == "CLEINTE" ? true : false;
	}
	
	public Integer logar() {
		System.out.println("Olá, seja bem vindo a Pastelaria \r\n");
		
		switch (opcao) {
			case 0:
				opcao = 1;
		}
		return 1;
	}
}
