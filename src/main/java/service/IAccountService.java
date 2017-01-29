package service;

import java.util.List;

import com.google.inject.ImplementedBy;

import bean.Account;

/**
 * アカウントに関連する抽象クラス
 *
 * @author k-furukawa
 */

@ImplementedBy(AccountService.class)
public interface IAccountService {

	public int insert();

	public int update();

	public List<Account> select();

	public Account select(String id, String password);

	public boolean existsAccount(String id, String pass);
}
