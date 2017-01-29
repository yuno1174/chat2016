package bean;

import java.io.Serializable;

public class Account implements Serializable{

	private long id;
	private String name;
	private boolean isAdmin;

	public Account() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Account(long id, String name, boolean isAdmin){
		this.id = id;
		this.name = name;
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
