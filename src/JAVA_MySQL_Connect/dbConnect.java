package JAVA_MySQL_Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbConnect {
    public static void main(String[] args) throws SQLException {

        //드라이버 확인
        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 로드하는데에 문제 발생" + e.getMessage());
            e.printStackTrace(); }*/

        Connection con = null;

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

            System.out.println("연결 완료!");

            //연결확인

            //SQL

            String sql = "insert into member values(?,?,?,?,?,now())";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, 6);
            pt.setInt(2, 1212);
            pt.setString(3, "prepared");
            pt.setString(4, "01013131414");
            pt.setString(5, "hey@naer.com");

//            pt.executeUpdate();


            //


            String sql2 = "update member set name=?, phone=?, email=? where id=? ";

            PreparedStatement pt2 = con.prepareStatement(sql2);

            pt2.setString(1, "jake");
            pt2.setString(2, "010-0101-1010");
            pt2.setString(3, "jake@daum.net");
            pt2.setString(4, "5");

//            pt2.executeUpdate();

            String sql3 = "delete from member where id = ?";

            PreparedStatement pt3 = con.prepareStatement(sql3);

            pt3.setInt(1, 6);

            pt3.executeUpdate();






            // 해제
        }catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();   }

        finally {
            try {
                con.close();
                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }



//
    }
}
