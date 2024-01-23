package EX99_Message;

import java.time.LocalDate;
import java.util.Scanner;

public class MessageServiceArrayImpl implements MessageService {
	private Message[] messageArray = new Message[10];
	private Scanner sc = new Scanner(System.in);
	private LocalDate t = LocalDate.now();

	public MessageServiceArrayImpl() {
		messageArray[0] = new Message(1000, "메세지 1번", "김찰일", t);
		messageArray[1] = new Message(1001, "메세지 2번", "김찰이", t);
		messageArray[2] = new Message(1002, "메세지 3번", "김찰삼", t);
		messageArray[3] = new Message(1003, "메세지 4번", "김찰사", t);
		messageArray[4] = new Message(1004, "메세지 5번", "김찰오", t);
	}

	@Override
	public Message findByMid(int mid) {

		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i].getMid() == mid) {
				return messageArray[i];
			}
		}
		return null;
	}

	@Override
	public void messageList() {
		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i] == null) {
				break;
			} else if (messageArray[i].getIsDeleted() == MessageService.DELETED) {
				continue;
			} else {
				System.out.println(messageArray[i].getMid() + " " + messageArray[i].getContent() + " "
						+ messageArray[i].getWriter() + " " + messageArray[i].getGenTime());
			}
		}
	}

	@Override
	public void messageListByWriter(String writer) {
		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i] == null) {
				break;
			} else if (messageArray[i].getIsDeleted() == MessageService.DELETED) {
				continue;
			}

			if (messageArray[i].getWriter().equals(writer)) {
				System.out.println(messageArray[i].getMid() + " " + messageArray[i].getContent() + " "
						+ messageArray[i].getWriter() + " " + messageArray[i].getGenTime());
			}
		}
	}

	@Override
	public void insertMessage(Message message) {
		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i] == null) {
				message.setMid(1000 + i);
				message.setGenTime(t);
				messageArray[i] = message;

				System.out.println("게시글이 작성 되었습니다.");
				break;
			}
		}
	}

	@Override
	public void updateMessage(Message message) {
		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i] == null) {
				break;
			} else if (messageArray[i].getIsDeleted() == MessageService.DELETED) {
				continue;
			}

			if (messageArray[i].getMid() == message.getMid()) {
				System.out.print("수정할 이름 입력> ");
				String uName = sc.nextLine();
				messageArray[i].setWriter(uName);
				System.out.print("수정할 내용 입력> ");
				String uContent = sc.nextLine();
				messageArray[i].setContent(uContent);

				System.out.println("게시글이 수정 되었습니다.");
				break;
			}
		}
	}

	@Override
	public void deleteMessage(int mid) {
		for (int i = 0; i < messageArray.length; i++) {
			if (messageArray[i].getMid() == mid) {
				messageArray[i].setIsDeleted(DELETED);
				break;
			}
		}
	}

}
