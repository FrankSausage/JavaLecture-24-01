package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_Select {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world",       // 호스트, 포트, DB명
                    "hmuser", "hmpass"                             // 사용자 이름, 패스워드
            );
            stmt = conn.createStatement();
            String sql = "select * from city where countrycode='KOR' limit 10";

            // Select 실행
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);      // rs.getInt("ID") 도 가능
                String name = rs.getString(2);
                String countryCode = rs.getString(3);
                String district = rs.getString(4);
                int population = rs.getInt(5);
                System.out.printf("%d, %s, %s, %s, %d%n", id, name, countryCode, district, population);
            }
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
