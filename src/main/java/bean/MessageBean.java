package bean;

import java.io.Serializable;
import java.sql.Date;

public class MessageBean implements Serializable{

	private long id;
	private String message;
	private AccountBean accountBean;
	private Date postTime;

	public MessageBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public MessageBean(long id, String name,
			AccountBean accountBean, Date postTime){
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
	 * @return name
	 */
	public String getName() {
		return message;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.message = name;
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
	public AccountBean getAccountBean() {
		return accountBean;
	}

	/**
	 * @param accountBean セットする accountBean
	 */
	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}

	/**
	 * @return postTime
	 */
	public Date getPostTime() {
		return postTime;
	}

	/**
	 * @param postTime セットする postTime
	 */
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}



}
