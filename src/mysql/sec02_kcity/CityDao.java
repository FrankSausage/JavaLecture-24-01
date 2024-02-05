package mysql.sec02_kcity;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
 *  City DAO (Data Access Object) - DB table을 다루는 라이브러리
 *       Select, Insert, Update, Delete 를 처리하는 프로그램
 * */
public class CityDao {
    private String connStr;
    private String user;
    private String password;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection myConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(connStr, user, password);
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public City getCityByID(int id){
        Connection conn = myConnection();
        String sql = "select * from kcity where id=?";
        City city = new City();       // 방법 1
        try {
            // 파라미터 세팅
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            // Select 실행하고 결과 받기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                city.setId(rs.getInt(1));
                city.setName(rs.getString(2));
                city.setCountryCode(rs.getString(3));
                city.setDistrict(rs.getString(4));
                city.setPopulation(rs.getInt(5));
            }
            rs.close(); conn.close(); pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return city;
    }

    public City getCityByName(String name){
        Connection conn = myConnection();
        String sql = "select * from kcity where name=?";
        City city = null;           // 방법 2
        try {
            // 파라미터 세팅
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                city = new City(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4 ),rs.getInt(5));
            }
            rs.close(); conn.close(); pstmt.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return city;
    }
}
