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
import bean.Message;
import difinition.DBSettingDefinition;

/**
 * アカウントに関連するDAO
 *
 * @author k-furukawa
 */
public class MessageDAO {

	/**
	 * コンストラクタ
	 */

	public MessageDAO() throws ClassNotFoundException {
		Class.forName(DBSettingDefinition.SQL_DRIVER);
	}

	/**
	 * 挿入メソッド
	 */
	public int insert(Message message) {

		int ret = -1;

		StringBuilder sql = new StringBuilder();


		sql.append("insert into message(accountid, message, posttime) ");
		sql.append("values(?,?,?) ");

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){

				pstmt.setLong(1, message.getAccountBean().getId());
				pstmt.setString(2, message.getMessage());
				pstmt.setTimestamp(3, message.getPostTime());

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

	/**
	 * 削除メソッド
	 */
	public void delete() {

	}


	public List<Message> select(){

		List<Message> list = new ArrayList<Message>();

		StringBuilder sql = new StringBuilder();
		sql.append("select A.id as accountid, ");
		sql.append("	   A.name as accountname, ");
		sql.append("	   A.isadmin, ");
		sql.append("	   B.id as messageid, ");
		sql.append("	   B.message, ");
		sql.append("	   B.posttime ");
		sql.append("from account A, ");
		sql.append("	 message B ");
		sql.append("where B.accountid = A.id ");

		try(Connection conn = DriverManager.getConnection(DBSettingDefinition.URL,
				DBSettingDefinition.USER, DBSettingDefinition.PASS)){
			try(Statement stmt = conn.createStatement()){

				try(ResultSet results = stmt.executeQuery(sql.toString())){
					while(results.next()){
						Account account = new Account();
						account.setId(results.getLong("accountid"));
						account.setName(results.getString("accountname"));
						account.setAdmin(results.getBoolean("isadmin"));

						Message message = new Message();
						message.setId(results.getLong("messageid"));
						message.setMessage(results.getString("message"));
						message.setAccountBean(account);
						message.setPostTime(results.getTimestamp("posttime"));

						list.add(message);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
