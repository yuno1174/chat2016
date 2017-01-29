package service;

import java.util.List;

import com.google.inject.ImplementedBy;

import bean.Message;

/**
 * アカウントに関連する抽象クラス
 *
 * @author k-furukawa
 */

@ImplementedBy(MessageService.class)
public interface IMessageService {

	public int insert(Message message);

	public List<Message> select();
}
