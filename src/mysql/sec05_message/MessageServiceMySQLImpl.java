package mysql.sec05_message;

import java.util.List;

public class MessageServiceMySQLImpl implements MessageService {
    private MessageDao msgDao = new MessageDao();

    @Override
    public Message findByMid(int mid) {
        Message m = msgDao.getMessageByMid(mid);
        return m;
    }

    @Override
    public List<Message> getMessageListAll() {
        List<Message> m = msgDao.getMessageListByWriter("%");
        return m;
    }

    @Override
    public List<Message> getMessageListByWriter(String writer) {
        List<Message> m = msgDao.getMessageListByWriter("%" + writer +"%");
        return m;
    }

    @Override
    public void insertMessage(Message message) {
        msgDao.insertMessage(message);
    }

    @Override
    public void updateMessage(Message message) {
        msgDao.updateMessage(message);
    }

    @Override
    public void deleteMessage(int mid) {
        msgDao.deleteMessage(mid);
    }

    @Override
    public void close() {
        msgDao.close();
    }
}
