package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex02_SelectWithParameter {
    public static void main(String[] args) {
        select("USA", 10);
    }

    static void select(String countryCode, int num) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
                    "hmuser", "hmpass"
            );
            String sql = "select * from city where countrycode=? limit ?";

            // SQL에 파라미터 세팅
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, countryCode);
            pstmt.setInt(2, num);

            // Select 실행후 결과를 ResultSet에 받기
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);      // rs.getInt("ID") 도 가능
                String name = rs.getString(2);
                countryCode = rs.getString(3);
                String district = rs.getString(4);
                int population = rs.getInt(5);
                System.out.printf("%d, %s, %s, %s, %d%n", id, name, countryCode, district, population);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
