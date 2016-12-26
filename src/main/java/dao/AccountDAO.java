package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.AccountBean;
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
	public void insert() {

	}

	/**
	 * 更新メソッド
	 */
	public void update() {

	}

	/**
	 * 削除メソッド
	 */
	public void delete() {

	}


	public List<AccountBean> select(){
		String sql = "select * from account;";
		List<AccountBean> accounts = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(Statement stmt = conn.createStatement()){
				ResultSet results = stmt.executeQuery(sql);
				while (results.next()) {
					accounts.add(new AccountBean(
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

	public boolean existsAccount(String name, String password){
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from account ");
		sql.append("where name = ? ");
		sql.append("and password = ? ");

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){

				pstmt.setString(1, name);
				pstmt.setString(2, password);

				try(ResultSet results = pstmt.executeQuery()){
					return results.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
