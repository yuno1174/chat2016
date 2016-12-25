package service;

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
	public void insert() {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void delete() {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void select() {
		// TODO 自動生成されたメソッド・スタブ
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
