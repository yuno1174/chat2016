package difinition;

/**
 * 接続先のDB設定の定義
 *
 * @author k-furukawa
 */
public class DBSettingDefinition {

	public static final String SQL_DRIVER = "org.postgresql.Driver";
	public static final String URL = "jdbc:postgresql://127.0.0.1:5432/chat2016";
	public static final String USER = "postgres";
	public static final String PASS = "postgres";

	DBSettingDefinition() {
		throw new AssertionError("インスタンス化してはいけない");
	}
}
