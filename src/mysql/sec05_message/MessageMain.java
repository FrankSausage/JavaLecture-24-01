package mysql.sec05_message;

import java.util.List;
import java.util.Scanner;

public class MessageMain {
	private static MessageService messageService = new MessageServiceMySQLImpl();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		List<Message> list = null;
		String writer = null, content = null;
		Message message = null;
		int mid = 0;
		boolean run = true;
		
		while (run) {
			System.out.println("+=============+=================+==========+==========+==========+========+");
			System.out.println("| 1. 전체목록 | 2.Writer별 목록 | 3.글쓰기 | 4.글수정 | 5.글삭제 | 6.종료 |");
			System.out.println("+=============+=================+==========+==========+==========+========+");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scan.nextLine());
			switch(selectNo) {
			case 1:
				list = messageService.getMessageListByWriter("%");
				list.forEach(System.out::println);
				System.out.println();
				break;
			case 2:
				System.out.println("---------------");
				System.out.println(" Writer별 목록");
				System.out.println("---------------");
				System.out.print("Writer 이름> ");
				writer = scan.nextLine();
				list = messageService.getMessageListByWriter(writer);
				list.forEach(System.out::println);
				System.out.println();
				break;
			case 3:
				System.out.println("---------------");
				System.out.println("  메세지 쓰기");
				System.out.println("---------------");
				System.out.print("Writer 이름> ");
				writer = scan.nextLine();
				System.out.print("메세지 내용> ");
				content = scan.nextLine();
				message = new Message(content, writer);
				messageService.insertMessage(message);
				break;
			case 4:
				System.out.println("---------------");
				System.out.println("  메세지 수정");
				System.out.println("---------------");
				System.out.print("메세지 ID> ");
				mid = Integer.parseInt(scan.nextLine());
				System.out.print("수정할 Writer> ");
				writer = scan.nextLine();
				System.out.print("수정할 메세지 내용> ");
				content = scan.nextLine();
				message = new Message(mid, writer, content);
				messageService.updateMessage(message);
				break;
			case 5:
				System.out.println("---------------");
				System.out.println("  메세지 삭제");
				System.out.println("---------------");
				System.out.print("메세지 ID> ");
				mid = Integer.parseInt(scan.nextLine());
				messageService.deleteMessage(mid);
				break;
			case 6:
				run = false;
				messageService.close();
				break;
			default:
				System.out.println("Warning: 1 ~ 6 사이의 숫자만 입력하세요.");
			}
		}
		System.out.println("프로그램 종료");
		scan.close();
	}

}
