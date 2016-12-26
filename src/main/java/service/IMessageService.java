package service;

import java.util.List;

import com.google.inject.ImplementedBy;

import bean.MessageBean;

/**
 * アカウントに関連する抽象クラス
 *
 * @author k-furukawa
 */

@ImplementedBy(MessageService.class)
public interface IMessageService {

	public void insert();

	public void update();

	public void delete();

	public List<MessageBean> select();
}
