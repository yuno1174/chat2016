package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{

	private long id;
	private String message;
	private Account accountBean;
	private Timestamp postTime;

	public Message() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Message(long id, String name,
			Account accountBean, Timestamp postTime){
		this.id = id;
		this.message = name;
		this.accountBean = accountBean;
		this.postTime = postTime;
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
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return accountBean
	 */
	public Account getAccountBean() {
		return accountBean;
	}

	/**
	 * @param accountBean セットする accountBean
	 */
	public void setAccountBean(Account accountBean) {
		this.accountBean = accountBean;
	}

	/**
	 * @return postTime
	 */
	public Timestamp getPostTime() {
		return postTime;
	}

	/**
	 * @param postTime セットする postTime
	 */
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}



}
