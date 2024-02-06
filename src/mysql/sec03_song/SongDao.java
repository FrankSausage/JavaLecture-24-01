package mysql.sec03_song;

import ch12_interface.sec05_default.A;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SongDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public SongDao() {
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

    public void close(){
        try{
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Song getSongBySid(int sid) {
        String sql = "select * from song where sid=?";
        Song song = new Song();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                song.setSid(rs.getInt(1));
                song.setTitle(rs.getString(2));
                song.setLyrics(rs.getString(3));
            }
            rs.close(); pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return song;
    }

    public Song getSongByTitle(String title) {
        String sql = "select * from song where title like ?";
        Song song = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");      // %별빛% - 제목에 별빛 검색

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int sid = rs.getInt(1);
                title = rs.getString(2);
                String lyrics = rs.getString(3);
                song = new Song(sid, title, lyrics);
            }
            rs.close(); pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return song;
    }

    public List<Song> getSongListAll() {
        String sql = "select * from song";
        List<Song> songList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
                songList.add(song);
            }
            stmt.close(); rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return songList;
    }

    public void insertSong(Song song){
        String sql = "insert song values(default, ?, ?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, song.getTitle());
            pstmt.setString(2, song.getLyrics());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSong(Song song){
        String sql = "update song set title=?, lyrics=? where sid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, song.getTitle());
            pstmt.setString(2, song.getLyrics());
            pstmt.setInt(3,song.getSid());

            pstmt.executeUpdate();
                pstmt.close();
            } catch (Exception e){
                e.printStackTrace();
            }
    }
    public void deleteSong(int sid){
        String sql = "delete from song where sid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sid);

            pstmt.executeUpdate();
                pstmt.close();
            } catch (Exception e){
                e.printStackTrace();
            }
    }
}
