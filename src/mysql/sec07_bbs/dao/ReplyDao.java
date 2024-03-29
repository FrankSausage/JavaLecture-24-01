package mysql.sec07_bbs.dao;

import mysql.sec07_bbs.entity.Reply;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReplyDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public ReplyDao() {
        String path = "C:/Users/human-18/Desktop/Java/lesson/src/mysql/sec07_bbs/mysql.properties";
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

    public List<Reply> getReplyList(int bid) {
        String sql = "SELECT r.*, u.uname FROM reply r" +
                " JOIN users u ON r.uid=u.uid" +
                " WHERE r.bid=?" +
                " ORDER BY rid";
        List<Reply> rList = new ArrayList<>();
        Reply reply = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                reply = new Reply();
                reply.setRid(rs.getInt(1));
                reply.setComment(rs.getString(2));
                reply.setRegTime(LocalDateTime.parse(rs.getString(3).replace(" ", "T")));
                reply.setUid(rs.getString(4));
                reply.setBid(rs.getInt(5));
                reply.setUname(rs.getString(6));
                rList.add(reply);
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rList;
    }

    public void insertReply(Reply reply) {
        String sql = "insert into reply values(default, ?, default, ?, ?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reply.getComment());
            pstmt.setString(2, reply.getUid());
            pstmt.setInt(3, reply.getBid());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
