package test.exam240214.Q2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CityDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public CityDao() {
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

    public City getCity(int id){
        String sql = "SELECT * FROM city WHERE id=?";
        City c = new City();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setCountryCode(rs.getString(3));
                c.setDistrict(rs.getString(4));
                c.setPopulation(rs.getInt(5));
            }
            pstmt.close(); rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return c;
    }

    public List<City> getCityList(String field, String query, int num, int offset){
        String sql = "SELECT * FROM city WHERE ?=? LIMIT ? OFFSET ?";
        List<City> cList = new ArrayList<>();
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, field);
            pstmt.setString(2, query);
            pstmt.setInt(2, num);
            pstmt.setInt(3, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                City c = new City();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setCountryCode(rs.getString(3));
                c.setDistrict(rs.getString(4));
                c.setPopulation(rs.getInt(5));
                cList.add(c);
            }
            pstmt.close(); rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return cList;
    }

    public void insertCity(City city){
        String sql = "insert into city values(default, ?, ?, ?, ?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,city.getName());
            pstmt.setString(2,city.getCountryCode());
            pstmt.setString(3,city.getDistrict());
            pstmt.setInt(4,city.getPopulation());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCity(City city){
        String sql = "update city set name=?, countrycode=?, district=?, population=? where id=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,city.getName());
            pstmt.setString(2,city.getCountryCode());
            pstmt.setString(3,city.getDistrict());
            pstmt.setInt(4,city.getPopulation());
            pstmt.setInt(5, city.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public void deleteCity(City city){
        String sql = "delete from city where id=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, city.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
