package br.com.pastelaria.empresa;

import br.com.pastelaria.compartilhado.*;

public class PrincipalEmpresa {
	public static void main(String[] args) {
		Integer retorno;
		//LoginGenerico login = new LoginGenerico();
		Menus menuLogin = new Menus();
		retorno = menuLogin.menuLogin(true);
		
		System.out.println("Retorno: " + retorno);
	}
}
