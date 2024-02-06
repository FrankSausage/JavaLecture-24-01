package mysql.sec04_girl_group;

import com.mysql.cj.exceptions.StreamingNotifiable;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GirlGroupDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public GirlGroupDao() {
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

    public GirlGroup getGirlGroupByGid(int gid) {
        String sql = "select * from girl_group where gid=?";
        GirlGroup gg = new GirlGroup();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                gg.setGid(rs.getInt(1));
                gg.setName(rs.getString(2));
                String debutString = rs.getString(3);             // yyyy-mm-dd
                gg.setDebut(LocalDate.parse(debutString));
                gg.setHitSongId(rs.getInt(4));
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gg;
    }

    public GirlGroup getGirlGroupByName(String name) {
        String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l" +
                " JOIN song r ON l.hit_song_id=r.sid" +
                " WHERE l.name LIKE ?";
        GirlGroup gg = new GirlGroup();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                gg.setGid(rs.getInt(1));
                gg.setName(rs.getString(2));
                gg.setDebut(rs.getDate(3).toLocalDate());
                gg.setHitSongTitle(rs.getString(4));
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gg;
    }

    public List<GirlGroup> getGirlGroupByDebutList(int fromYear, int toYear) {
        List<GirlGroup> ggList = new ArrayList<>();
        String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l" +
                " JOIN song r ON l.hit_song_id=r.sid" +
                " WHERE l.debut BETWEEN ? AND ?" +
                " ORDER BY l.debut";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fromYear + "-01-01");
            pstmt.setString(2, toYear + "-12-31");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                GirlGroup gg = new GirlGroup(rs.getInt(1), rs.getString(2),
                        rs.getDate(3).toLocalDate(), rs.getString(4)
                );
                ggList.add(gg);
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ggList;
    }

    public void insertGirlGroup(GirlGroup gg) {
        String sql = "insert into girl_group values(default, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gg.getName());
            pstmt.setString(2, gg.getDebut().toString());
            pstmt.setInt(3, gg.getHitSongId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGirlGroup(GirlGroup gg){
        String sql = "update girl_group set name=?, debut=?, hit_song_id=? where gid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gg.getName());
            pstmt.setString(2, gg.getDebut().toString());
            pstmt.setInt(3,gg.getHitSongId());
            pstmt.setInt(4, gg.getGid());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteGirlGroup(int gid) {
        String sql = "delete from girl_group where gid=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gid);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
