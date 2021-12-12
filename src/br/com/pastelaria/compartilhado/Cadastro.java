package br.com.pastelaria.compartilhado;

import br.com.pastelaria.cliente.PrincipalCliente;
import br.com.pastelaria.empresa.PrincipalEmpresa;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Cadastro {
	Boolean isCliente;
	CRUD crud;

	public Cadastro(Boolean isClinete) {
		this.isCliente = isClinete;

		if (isCliente) {
			crud = new CRUD(PrincipalCliente.conexao);
		} else {
			crud = new CRUD(PrincipalEmpresa.conexao);
		}
	}

	public Integer usuario() {
		String nomeUsuario, tipousuario = (this.isCliente) ? "C" : "F";
		Integer retorno;
		Map<String, String> sql = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);

		sql.put("TABELA", "USUARIO");
		sql.put("COLUNAS", "NOMEUSUARIO, SENHA, IDADE, CPF, CELULAR" + "EMAIL, CIDADE, BAIRRO, RUA, NUMEROCASA"
				+ "COMPLEMENTO, OBSERVACAO, TIPOUSUARIO");

		System.out.println("=============================");
		System.out.println("==== CADASTRO DE USUÁRIO ====\n");
		System.out.println("Digite o nome de usuário:");
		nomeUsuario = scan.next();

		do {
			retorno = this.usuarioExiste(nomeUsuario);

			if (retorno == 2) {
				System.out.println("O nome de usuário informado já existe, por favor informe outro:");
				nomeUsuario = scan.next();
			} else if (retorno == 1) {
				sql.put("VALORES", "NOMEUSUARIO = '" + nomeUsuario + "'");
			} else {
				return 0;
			}

		} while (retorno != 2);

		System.out.println("Digite a senha:");
		sql.put("VALORES", sql.get("VALORES") + "SENHA = '" + scan.next() + "'");
		System.out.println("Digite a idade:");
		sql.put("VALORES", sql.get("VALORES") + "IDADE = '" + scan.nextInt() + "'");
		System.out.println("Digite o CPF:");
		sql.put("VALORES", sql.get("VALORES") + "CPF = '" + scan.nextInt() + "'");
		System.out.println("Digite o número do celular:");
		sql.put("VALORES", sql.get("VALORES") + "CELULAR = '" + scan.nextInt() + "'");
		System.out.println("Digite o e-mail:");
		sql.put("VALORES", sql.get("VALORES") + "EMAIL = '" + scan.next() + "'");
		System.out.println("Digite o nome da ciade:");
		sql.put("VALORES", sql.get("VALORES") + "CIDADE = '" + scan.next() + "'");
		System.out.println("Digite o nome do bairro:");
		sql.put("VALORES", sql.get("VALORES") + "BAIRRO = '" + scan.next() + "'");
		System.out.println("Digite o nome da rua:");
		sql.put("VALORES", sql.get("VALORES") + "RUA = '" + scan.next() + "'");
		System.out.println("Digite o numero da casa:");
		sql.put("VALORES", sql.get("VALORES") + "NUMEROCASA = '" + scan.nextInt() + "'");
		System.out.println("Digite um complemento:");
		sql.put("VALORES", sql.get("VALORES") + "COMPLEMENTO = '" + scan.next() + "'");
		System.out.println("Digite uma observação:");
		sql.put("VALORES", sql.get("VALORES") + "OBSERVACAO = '" + scan.next() + "'");

		sql.put("VALORES", sql.get("VALORES") + "TIPOUSUARIO = '" + tipousuario + "'");

		if (crud.insert(sql) == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	private Integer usuarioExiste(String nome) {
		String tipousuario;
		Map<String, String> atributo = new HashMap<String, String>();

		if (isCliente) {
			tipousuario = "C";
		} else {
			tipousuario = "F' OR TIPOUSUARIO = 'A";
		}

		atributo.put("TABELA", "USUARIO");
		atributo.put("CLAUSULA", "NOMEUSUARIO = '" + nome + "'  AND (TIPOUSUARIO = '" + tipousuario + "')");

		return crud.validarLogin(atributo);
	}
}