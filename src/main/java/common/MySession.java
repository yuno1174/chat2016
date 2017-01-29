package common;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import bean.Account;

public final class MySession extends WebSession{

	private Account accountBean;
	private boolean loggedIn;

	public MySession(Request request) {
		super(request);
		accountBean = null;
	}

	public static MySession get() {
		return (MySession) WebSession.get();
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
	 * @return loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * @param loggedIn セットする loggedIn
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
