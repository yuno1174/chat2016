package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Account;
import difinition.DBSettingDefinition;

/**
 * アカウントに関連するDAO
 *
 * @author k-furukawa
 */
public class AccountDAO {

	/**
	 * コンストラクタ
	 */

	public AccountDAO() throws ClassNotFoundException {
		Class.forName(DBSettingDefinition.SQL_DRIVER);
	}

	/**
	 * 挿入メソッド
	 */
	public int insert(String name, String password, boolean isAdmin) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Account(name, password, isadmin) ");
		sql.append("values(?,?,?) ");

		int ret = 0;

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){

				pstmt.setString(1, name);
				pstmt.setString(2, password);
				pstmt.setBoolean(3, isAdmin);

				ret = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * 更新メソッド
	 */
	public void update() {

	}


	public List<Account> select(){
		String sql = "select * from account;";
		List<Account> accounts = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(Statement stmt = conn.createStatement()){
				ResultSet results = stmt.executeQuery(sql);
				while (results.next()) {
					accounts.add(new Account(
							results.getLong("id"),
							results.getString("name"),
							results.getBoolean("isAdmin")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public Account select(String name, String password){
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, isadmin ");
		sql.append("from account ");
		sql.append("where name = ? ");
		sql.append("and password = ? ");

		Account account = new Account();

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){

				pstmt.setString(1, name);
				pstmt.setString(2, password);

				try(ResultSet results = pstmt.executeQuery()){
					if(results.next()){
						account.setId(results.getLong("id"));
						account.setName(results.getString("name"));
						account.setAdmin(results.getBoolean("isAdmin"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	public boolean existsAccount(String name){
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from account ");
		sql.append("where name = ? ");

		boolean ret = false;

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){

				pstmt.setString(1, name);

				try(ResultSet results = pstmt.executeQuery()){
					ret = results.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
