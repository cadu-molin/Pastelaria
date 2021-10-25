package br.com.pastelaria.empresa;

import br.com.pastelaria.compartilhado.*;

public class PrincipalEmpresa {
	public static void main(String[] args) {
		Integer retorno;
		LoginGenerico login = new LoginGenerico("Cliente");
		//Menus menuLogin = new Menus();
		retorno = login.logar();
		
		System.out.println("Retorno: " + retorno);
	}
}
