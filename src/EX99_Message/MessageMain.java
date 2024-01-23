package EX99_Message;

import java.util.Scanner;

public class MessageMain {

	public static void main(String[] args) {
		MessageServiceArrayImpl msImpl = new MessageServiceArrayImpl();
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			int index = 0;
			String writer = "";
			System.out.println(
					"+============++============++============++============++=================++============+");
			System.out.println("| 1.게시물 목록 | 2.작가 검색 | 3.게시글 작성 | 4. 게시글 수정 | 5.게시글 삭제 | 6.종료 |");
			System.out.println(
					"+============++============++============++============++=================++============+");
			System.out.print("선택> ");
			int selectNum = Integer.parseInt(sc.nextLine());

			switch (selectNum) {
			case 1:
				msImpl.messageList();
				break;
			case 2:
				System.out.println("찾고자 하는 작가 검색> ");
				writer = sc.nextLine();
				msImpl.messageListByWriter(writer);
				break;
			case 3:
				System.out.println("게시글 신규 작성> ");
				System.out.print("이름 입력> ");
				String newName = sc.nextLine();
				System.out.println("내용 입력>");
				String newContent = sc.nextLine();
				Message newAccount = new Message(newContent, newName);
				msImpl.insertMessage(newAccount);
				break;
			case 4:
				System.out.println("수정할 게시글 ID 검색> ");
				index = Integer.parseInt(sc.nextLine());
				msImpl.updateMessage(msImpl.findByMid(index));
				break;
			case 5:
				System.out.println("삭제 할 작가 ID> ");
				index = Integer.parseInt(sc.nextLine());
				msImpl.deleteMessage(index);
				break;
			case 6:
				run = false;
				break;
			default:
				System.out.println("올바른 값을 입력해주세요.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
