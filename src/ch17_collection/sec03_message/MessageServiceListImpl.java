package ch17_collection.sec03_message;

import java.time.LocalDateTime;
import java.util.*;

public class MessageServiceListImpl implements MessageService {
    List<Message> mList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public Message findByMid(int mid) {
        Message id = null;
        for (Message m : mList) {
            if (m.getMid() == mid) {
                id = m;
                break;
            }
        }
        return id;
    }

    @Override
    public List<Message> getMessageListAll() {
        List<Message> allList = new ArrayList<>();
        for (Message m : mList) {
            allList.add(m);
        }
        return allList;
    }

    @Override
    public List<Message> getMessageListByWriter(String writer) {
        List<Message> writerList = new ArrayList<>();

        for (Message m : mList) {
            if (m.getWriter().equals(writer)) {
                writerList.add(m);
            } else {
                System.out.println("작가가 존재하지 않습니다.");
            }
        }
        return writerList;
    }

    @Override
    public void insertMessage(Message message) {
        Message newMessage = new Message(mList.size(), message.getContent(), message.getWriter(), LocalDateTime.now());
        mList.add(newMessage);
        System.out.println("작성이 완료 되었습니다.");
    }

    @Override
    public void updateMessage(Message message) {
        if (!mList.contains(message)) {
            System.out.println("번호가 올바르지 않습니다.");
            return;
        }

        for (Message m : mList) {
            if (m.getIsDeleted() != DELETED && m.getMid() == message.getMid()) {
                System.out.print("(" + m.getWriter() + ")" + "   " + "수정할 저자 입력> ");
                String newWriter = sc.nextLine();
                System.out.print("(" + m.getContent() + ")" + "   " + "수정할 내용 입력> ");
                String newContent = sc.nextLine();

                m.setContent(newContent);
                m.setWriter(newWriter);
                m.setModTime(LocalDateTime.now());

                System.out.println("수정이 완료 되었습니다.");
                break;
            }
        }
    }

    @Override
    public void deleteMessage(int mid) {
        if (findByMid(mid) == null) {
            System.out.println("번호가 올바르지 않습니다.");
            return;
        }

        for (Message m : mList) {
            if (m.getMid() == mid) {
                mList.remove(m);

                System.out.println("삭제 되었습니다.");
                break;
            }
        }
    }
}
