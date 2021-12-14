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
		String nomeUsuario, senha, email, ciade, bairro, rua, complemento, observacao,
				tipousuario = (this.isCliente) ? "C" : "U";
		Integer idade, cpf, celular, numeroCasa, retorno;
		Map<String, String> sql = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);

		sql.put("TABELA", "USUARIO");
		sql.put("COLUNAS", "NOMEUSUARIO, SENHA, IDADE, CPF, CELULAR, " + "EMAIL, CIDADE, BAIRRO, RUA, NUMEROCASA, "
				+ "COMPLEMENTO, OBSERVACAO, TIPOUSUARIO");

		System.out.println("=============================");
		System.out.println("==== CADASTRO DE USUÁRIO ====\n");
		System.out.println("Digite o nome de usuário:");
		nomeUsuario = scan.nextLine();

		do {
			retorno = this.usuarioExiste(nomeUsuario);

			if (retorno == 2) {
				System.out.println("O nome de usuário informado já existe, por favor informe outro:");
				nomeUsuario = scan.nextLine();
			} else if (retorno == 1) {
				sql.put("VALORES", "'" + nomeUsuario + "', ");
			} else {
				return 0;
			}

		} while (retorno == 2);

		System.out.println("Digite a senha:");
		senha = scan.nextLine();
		System.out.println("Digite a idade:");
		idade = scan.nextInt();
		System.out.println("Digite o CPF:");
		cpf = scan.nextInt();
		System.out.println("Digite o número do celular:");
		celular = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite o e-mail:");
		email = scan.nextLine();
		System.out.println("Digite o nome da cidade:");
		ciade = scan.nextLine();
		System.out.println("Digite o nome do bairro:");
		bairro = scan.nextLine();
		System.out.println("Digite o nome da rua:");
		rua = scan.nextLine();
		System.out.println("Digite o numero da casa:");
		numeroCasa = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite um complemento:");
		complemento = scan.nextLine();
		System.out.println("Digite uma observação:");
		observacao = scan.nextLine();

		sql.put("VALORES", sql.get("VALORES") + "'" + senha + "', ");
		sql.put("VALORES", sql.get("VALORES") + "" + idade + ", ");
		sql.put("VALORES", sql.get("VALORES") + "" + cpf + ", ");
		sql.put("VALORES", sql.get("VALORES") + "" + celular + ", ");
		sql.put("VALORES", sql.get("VALORES") + "'" + email + "', ");
		sql.put("VALORES", sql.get("VALORES") + "'" + ciade + "', ");
		sql.put("VALORES", sql.get("VALORES") + "'" + bairro + "', ");
		sql.put("VALORES", sql.get("VALORES") + "'" + rua + "', ");
		sql.put("VALORES", sql.get("VALORES") + "" + numeroCasa + ", ");
		sql.put("VALORES", sql.get("VALORES") + "'" + complemento + "', ");
		sql.put("VALORES", sql.get("VALORES") + "'" + observacao + "', ");
		sql.put("VALORES", sql.get("VALORES") + "'" + tipousuario + "'");

		if (crud.insert(sql) == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public Integer produto() {
		String descricaoProduto, ingredientes, observacao;
		Double valor;
		Map<String, String> sql = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);

		sql.put("TABELA", "PRODUTO");
		sql.put("COLUNAS", "DESCRICAOPRODUTO, INGREDIENTES, VALOR, OBSERVACAO");

		System.out.println("=============================");
		System.out.println("==== CADASTRO DE PRODUTO ====\n");
		System.out.println("Digite o nome do produto:");
		descricaoProduto = scan.nextLine();
		System.out.println("Digite os ingredientes:");
		ingredientes = scan.nextLine();
		System.out.println("Digite o valor:");
		valor = scan.nextDouble();
		System.out.println("Digite um observação:");
		observacao = scan.nextLine();

		sql.put("VALORES", sql.get("VALORES") + "'" + descricaoProduto + "', ");
		sql.put("VALORES", sql.get("VALORES") + "" + ingredientes + ", ");
		sql.put("VALORES", sql.get("VALORES") + "" + valor + ", ");
		sql.put("VALORES", sql.get("VALORES") + "" + observacao + ", ");

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
			tipousuario = "U' OR TIPOUSUARIO = 'A";
		}

		atributo.put("TABELA", "USUARIO");
		atributo.put("CLAUSULA", "NOMEUSUARIO = '" + nome + "'  AND (TIPOUSUARIO = '" + tipousuario + "')");

		return crud.validarLogin(atributo);
	}
}