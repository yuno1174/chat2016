package service;

import java.util.List;

import bean.Message;
import dao.MessageDAO;

public class MessageService implements IMessageService {

	@Override
	public int insert(Message message) {
		MessageDAO dao = null;
		try {
			dao = new MessageDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dao.insert(message);
	}

	@Override
	public List<Message> select() {
		List<Message> list = null;
		try {
			list = new MessageDAO().select();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
