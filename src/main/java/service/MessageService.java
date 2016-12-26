package service;

import java.util.List;

import bean.MessageBean;
import dao.MessageDAO;

public class MessageService implements IMessageService {

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
	public List<MessageBean> select() {
		List<MessageBean> list = null;
		try {
			list = new MessageDAO().select();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
