package EX99_Message;

import java.time.LocalDate;
import java.util.Scanner;

public class MessageServiceArrayImpl implements MessageService {
	private static Message[] messageArray = new Message[10];
	private static Scanner sc = new Scanner(System.in);

	public MessageServiceArrayImpl() {
		LocalDate t = LocalDate.now();
		messageArray[0] = new Message(1000, "메세지 1번", "김찰일", t);
		messageArray[1] = new Message(1001, "메세지 2번", "김찰이", t);
		messageArray[2] = new Message(1002, "메세지 3번", "김찰삼", t);
		messageArray[3] = new Message(1003, "메세지 4번", "김찰사", t);
		messageArray[4] = new Message(1004, "메세지 5번", "김찰오", t);
	}

	@Override
	public Message findByMid(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void messageList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageListByWriter(String writer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(int mid) {
		// TODO Auto-generated method stub

	}

}
