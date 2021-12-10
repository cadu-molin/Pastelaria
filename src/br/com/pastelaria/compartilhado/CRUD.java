package br.com.pastelaria.compartilhado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class CRUD {
	private Connection con;
	protected String tabela;
	private String insertSQL;
	private String updateSQL;

	public CRUD(Connection con) {
		this.con = con;
	}

//	protected void setStatementValues(PreparedStatement stmt, Object object) throws SQLException;
//
//	protected Object createObject(ResultSet rs) throws SQLException;

	protected void setInsertSQL(String sql) {
		this.insertSQL = sql;
	}

	protected void setUpdateSQL(String sql) {
		this.updateSQL = sql;
	}

//	public void insert(Object object) {
//		System.out.println(this.insertSQL);
//		try (PreparedStatement stmt = this.con.prepareStatement(this.insertSQL)) {
//			this.setStatementValues(stmt, object);
//			stmt.execute();
//		} catch (SQLException ex) {
//			this.treatException(ex);
//		}
//	}
//
//	public void update(Object object) {
//		try (PreparedStatement stmt = this.con.prepareStatement(this.updateSQL)) {
//			this.setStatementValues(stmt, object);
//			stmt.execute();
//		} catch (SQLException ex) {
//			this.treatException(ex);
//		}
//	}

	public void delete(Object object) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", this.tabela);
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {

			// tmt.setInt(1, object.getId());
			stmt.execute();
		} catch (SQLException ex) {
			this.treatException(ex);
		}
	}
//
//	public Object find(int id) {
//		String sql = String.format("SELECT * FROM %s WHERE id = ?", this.tabela);
//		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
//			stmt.setInt(1, id);
//			stmt.execute();
//			return executeResultSet(stmt);
//		} catch (SQLException ex) {
//			this.treatException(ex);
//			return null;
//		}
//
//	}
//
//	@SuppressWarnings("rawtypes")
//	public ArrayList findAll() {
//		String sql = String.format("SELECT * FROM %s", this.tabela);
//		try (Statement stmt = this.con.createStatement()) {
//			stmt.execute(sql);
//			ArrayList list = new ArrayList<>();
//			return executeResultSet(stmt, list);
//		} catch (SQLException ex) {
//			this.treatException(ex);
//			return null;
//		}
//	}

//	public Integer validarLogin(Map<String, String> valores) {
//		String sql = String.format("SELECT 1 FROM ? WHERE ?");
//		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
//			stmt.setString(1, valores.get("TABELA"));
//			stmt.setString(2, valores.get("CLAUSULA"));
//			//stmt.execute(sql);
//			ResultSet rs = stmt.executeQuery(sql);
//			rs.next();
//			return rs.getInt(1);
//			//return executeResultSet(stmt);
//		} catch (SQLException ex) {
//			this.treatException(ex);
//			return 0;
//		}
//	}

//	public Integer validarLogin(Map<String, String> valores) {
//		String sql = String.format("SELECT 1 FROM ? WHERE ?");
//		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
//			stmt.setString(1, valores.get("TABELA"));
//			stmt.setString(2, valores.get("CLAUSULA"));
//			// stmt.execute(sql);
//			ResultSet rs = stmt.executeQuery(sql);
//			rs.next();
//			return rs.getInt(1);
//			// return executeResultSet(stmt);
//		} catch (SQLException ex) {
//			this.treatException(ex);
//			return 0;
//		}
//	}

	public Integer validarLogin(Map<String, String> valores) {
		String sql = String.format("SELECT 1 FROM %s WHERE %s", valores.get("TABELA"), valores.get("CLAUSULA"));
		try (PreparedStatement stmt = this.con.prepareStatement(sql)) {
//			stmt.setString(1, valores.get("TABELA"));
//			stmt.setString(2, valores.get("CLAUSULA"));
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				rs.next();
				if ((rs != null) && (rs.getInt(1) > 0)) {
					return 1;
				}else {
					return 0;
				}
//				rs.next();
//				return rs.getInt(1);
			} catch (Exception ex) {
				System.out.println("\n====================================");
				System.out.println("*      Ops! Algo deu errado        *");
				System.out.println("* Talvez seja culpa do programador *");
				System.out.println("* Ou talvez o problema é um BIOS   *");
				System.out.println("====================================\n");
				return 0;
			}
		} catch (SQLException ex) {
			this.treatException(ex);
			return null;
		}
	}

//	private Object executeResultSet(PreparedStatement stmt) {
//		try (ResultSet rs = stmt.getResultSet()) {
//			rs.next();
//			return this.createObject(rs);
//		} catch (Exception ex) {
//			this.treatException(ex);
//			return null;
//		}
//	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private ArrayList executeResultSet(Statement stmt, ArrayList list) {
//		try (ResultSet rs = stmt.getResultSet()) {
//			while (rs.next()) {
//				Object object = this.createObject(rs);
//				list.add(object);
//			}
//		} catch (Exception ex) {
//			this.treatException(ex);
//		}
//		return list;
//	}

	private void treatException(Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	}

}