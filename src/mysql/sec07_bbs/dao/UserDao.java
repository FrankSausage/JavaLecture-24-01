package mysql.sec07_bbs.dao;

import mysql.sec07_bbs.entity.User;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public UserDao() {
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

    public User getUserByUid(String uid) {
        String sql = "select * from users where uid=?";
        User user = null;
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUid(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setUname(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setRegDate(rs.getDate(5).toLocalDate());
                user.setIsDeleted(rs.getInt(6));
            }
            pstmt.close(); rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUserList(int num, int offset) {
        String sql = "select * from users where isDeleted=0" +
                    " order by regDate desc, uid limit ? offset ?";
        List<User> uList = new ArrayList<>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setInt(2, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUid(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setUname(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setRegDate(rs.getDate(5).toLocalDate());
                user.setIsDeleted(rs.getInt(6));

                uList.add(user);
            }
            pstmt.close(); rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return uList;
    }

    public void insertUser(User user) {
        String sql = "insert into users values(?, ?, ?, ?, default, default)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUid());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getUname());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateUser(User user) {
        String sql = "update users set pwd=?, uname=?, email=? where uid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getPwd());
            pstmt.setString(2, user.getUname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUid());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteUser(String uid) {
        String sql = "update users set isDeleted=1 where uid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,uid);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
