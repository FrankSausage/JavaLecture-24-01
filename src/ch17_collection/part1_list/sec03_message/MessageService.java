package ch17_collection.part1_list.sec03_message;

import java.util.List;

public interface MessageService {
	int DELETED = 1;

	Message findByMid(int mid);

	List<Message> getMessageListAll();

	List<Message> getMessageListByWriter(String writer);

	void insertMessage(Message massage);

	void updateMessage(Message massage);

	void deleteMessage(int mid);
}
