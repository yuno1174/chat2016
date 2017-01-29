package service;

import java.util.ArrayList;
import java.util.List;

import bean.Account;
import dao.AccountDAO;

/**
 * アカウントに関連するService
 *
 * @author k-furukawa
 */
public class AccountService implements IAccountService {

	/**
	 * コンストラクタ
	 */
	public AccountService(){

	}

	@Override
	public int insert() {
		return 0;
	}

	@Override
	public int update() {
		return 0;
	}

	@Override
	public List<Account> select() {
		return new ArrayList<Account>();
	}

	@Override
	public Account select(String id, String password) {
		if(!id.isEmpty() && !password.isEmpty()){
			try {
				return new AccountDAO().select(id, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new Account();
	}

	@Override
	public boolean existsAccount(String id, String pass) {
		if(!id.isEmpty() && !pass.isEmpty()){
			try {
				return new AccountDAO().existsAccount(id, pass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
