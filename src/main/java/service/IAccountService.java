package service;

import com.google.inject.ImplementedBy;

/**
 * アカウントに関連する抽象クラス
 *
 * @author k-furukawa
 */

@ImplementedBy(AccountService.class)
public interface IAccountService {

	public void insert();

	public void update();

	public void delete();

	public void select();

	public boolean existsAccount(String id, String pass);
}
