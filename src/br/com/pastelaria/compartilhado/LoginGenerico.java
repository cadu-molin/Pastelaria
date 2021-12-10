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
		CRUD crud;
		
		if  (isCliente) {
			crud = new CRUD(PrincipalCliente.conexao);
		}else {
			crud = new CRUD(PrincipalEmpresa.conexao);
		}
		
		do {
			System.out.println("========= LOGIN =========");
			System.out.println("Digite o nome do usuário: ");
			usuario = scan.next();
			
			System.out.println("Digite sua senha: ");
			senha = scan.next();
			
			if (crud.validarLogin(this.parametroValidacao(usuario, senha)) == 1) {
				System.out.println("\nParabens! Você deve ser muito esperto por lembrar sua própria senha.");
				contador = 0;
			} else {
				System.out.println("Usuário ou senha inválida, tente novamente.");
				contador += 1;
			}
		} while (contador > 0);
		return 1;
	}
	
	private Map<String, String> parametroValidacao(String usuario, String senha) {
		Map <String, String> atributo = new HashMap<String, String>();
		
		atributo.put("TABELA", "USUARIO");
		atributo.put("CLAUSULA","NOMEUSUARIO = '" + usuario + "' AND SENHA = '" + senha + "' AND TIPOUSUARIO");
		return atributo;
	}
}
