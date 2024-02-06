package mysql.sec05_message;

import java.io.FileInputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessageDao{
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public MessageDao() {
        String path = "C:/Users/human-18/Desktop/Java/lesson/src/mysql/mysql.properties";
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(path));

            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            String database = prop.getProperty("database");
            this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
            this.conn = DriverManager.getConnection(connStr, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public List<Message> getMessageListAll(){
//        String sql = "select * from message";
//        List<Message> mList = new ArrayList<>();
//        try{
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                Message message = new Message(rs.getInt(1), rs.getString(2),
//                        rs.getString(3), rs.getTimestamp(4).toLocalDateTime());
//                mList.add(message);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return mList;
//    }

    public Message getMessageByMid(int mid){
        String sql = "select * from message where mid=?";
        Message ms = null;
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                ms.setMid(rs.getInt(1));
                ms.setContent(rs.getString(2));
                ms.setWriter(rs.getString(3));
              String modTime = rs.getString(4);
              ms.setModTime(LocalDateTime.parse(modTime.replace(" ", "T")));
//                ms.setModTime(LocalDateTime.parse(rs.getString(4)));
            }
            pstmt.close(); rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return ms;
    }

    public List<Message> getMessageListByWriter(String writer){
        String sql = "select * from message where writer like ? and isDeleted=0";
        List<Message> mList = new ArrayList<>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String modTime = rs.getString(4);
                Message ms = new Message(rs.getInt(1), rs.getString(2), rs.getString(3),
                        LocalDateTime.parse(modTime.replace(" ", "T")), 0);
                mList.add(ms);
            }
            pstmt.close(); rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mList;
    }

    public void insertMessage(Message msg) {
        String sql = "insert into message values(default, ?, ?, default, default)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, msg.getContent());
            pstmt.setString(2, msg.getWriter());
//            LocalDateTime modTime = LocalDateTime.now();
//            pstmt.setString(3,
//                    modTime.toString().replaceAll("T", " ").substring(0, 16)
//            );

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateMessage(Message msg) {
        String sql = "update message set content=?, writer=? where mid=? and isDeleted=0";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, msg.getContent());
            pstmt.setString(2, msg.getWriter());
            pstmt.setInt(3, msg.getMid());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteMessage(int mid) {
        String sql = "delete from message where mid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mid);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
