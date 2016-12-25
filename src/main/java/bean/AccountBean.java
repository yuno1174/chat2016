package bean;

import java.io.Serializable;

public class AccountBean implements Serializable{

	private long id;
	private String name;
	private String password;
	private boolean isAdmin;

	public AccountBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public AccountBean(long id, String name, String password, boolean isAdmin){
		this.id = id;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin セットする isAdmin
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


}
