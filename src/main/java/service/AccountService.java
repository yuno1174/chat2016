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
	public int insert(String name, String password, boolean isAdmin){

		int ret = 0;
		if(!name.isEmpty() && !password.isEmpty()){
			try {
				return new AccountDAO().insert(name, password, isAdmin);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return ret;
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
	public Account select(String name, String password) {
		if(!name.isEmpty() && !password.isEmpty()){
			try {
				return new AccountDAO().select(name, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new Account();
	}

	@Override
	public boolean existsAccount(String name) {
		if(!name.isEmpty()){
			try {
				return new AccountDAO().existsAccount(name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
