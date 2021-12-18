package br.com.pastelaria.compartilhado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.util.Map;

public class CRUD {
	private Connection con;
	protected String tabela;
//	private String insertSQL;
//	private String updateSQL;

	public CRUD(Connection con) {
		this.con = con;
	}

	public Integer insert(Map<String, String> map) {
		String sql = String.format("INSERT INTO %s(%s) VALUES(%s)", map.get("TABELA"), map.get("COLUNAS"), map.get("VALORES"));
 		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
			stmt.executeUpdate();
			return 1;
		} catch (SQLException ex) {
			System.out.println("Falha ao inserir o novo usuário!\n");
			return 0;
		}
	}

	public Integer update(Map<String, String> map) {
		String sql = String.format("UPDATE %s SET %s WHERE(%s)", map.get("TABELA"), map.get("SET"), map.get("WHERE"));
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
			stmt.executeUpdate();
			return 1;
		} catch (SQLException ex) {
			System.out.println("Não foi possível efetuar o update!\n");
			return 0;
		}
	}

	public void delete(Map<String, String> map) {
		String sql = String.format("DELETE FROM %s WHERE id = %s", map.get("TABELA"), map.get("WHERE"));
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Não foi possível efetuar o delete!\n");
		}
	}

	public Object find(Map<String, String> map) {
		String sql = String.format("SELECT * FROM %s WHERE %s", map.get("TABELA"), map.get("WHERE"));
		Integer idusuario = 0;
		try (Statement stmt = this.con.createStatement()) {
			ResultSet rsRetorno = stmt.executeQuery(sql);
			while(rsRetorno.next()) {
				idusuario = rsRetorno.getInt("idusuario");
			}
			return idusuario;
		} catch (SQLException ex) {
			System.out.println("Não foi possível efetuar o find!\n");
			return null;
		}

	}

	@SuppressWarnings("rawtypes")
	public ArrayList findAll(Map<String, String> map) {
		String sql = String.format("SELECT * FROM %s", map.get("TABELA"));
		try (Statement stmt = this.con.createStatement()) {
			ResultSet rsRetorno = stmt.executeQuery(sql);
			ArrayList<Object> list = new ArrayList<>();
			while(rsRetorno.next()) {
				list.add(rsRetorno.getInt("idusuario"));
			}
			return list;
		} catch (SQLException ex) {
			System.out.println("Não foi possível efetuar o find all!\n");
			return null;
		}
	}

	public Integer validarLogin(Map<String, String> valores) {
		String sql = String.format("SELECT 1 FROM %s WHERE %s", valores.get("TABELA"), valores.get("CLAUSULA"));
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				if (rs.next()) {
					if (rs.getInt(1) == 1) {
						return 2;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} catch (Exception ex) {
				System.out.println("Prezado usuário, houve um pequeno problema.\n");
				return 0;
			}
		} catch (SQLException ex) {
			System.out.println(
					"Prezado usuário, algo deu errado, por conta disso não foi possível te reconhecer meu consagrado!\n");
			return 0;
		}
	}
}