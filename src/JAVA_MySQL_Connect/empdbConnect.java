package JAVA_MySQL_Connect;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class empdbConnect {
    public static void main(String[] args) {

        Connection con = null;
        try { con = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:3306/empdb", "june", "dnjffl12!@");
            System.out.println("연결 완료!");

//SQL

            String sql1 = "select * from employees where first_name = ? ";

            PreparedStatement pt1 = con.prepareStatement(sql1);

            pt1.setString(1, "june");

            ResultSet resultSet = pt1.executeQuery();


            resultSet.next();

            System.out.println(resultSet.getString(1)+" " +
                            resultSet.getString(2) + " " +
                            resultSet.getString(3) + " " +
                            resultSet.getString(4) + " " +
                            resultSet.getString(5)
                    );


            String sql2 = "select first_name, ifnull(department_name,?), ifnull(city,?)"
                    + " from employees e inner join departments d on e.department_id=d.department_id"
                    + " inner join locations l on d.location_id=l.location_id"
                    + " where d.department_id=?";

            PreparedStatement pt = con.prepareStatement(sql2);

            pt.setString(1, "부서없음");
            pt.setString(2, "이사중");
            pt.setString(3, "50");
            ResultSet rs1 = pt.executeQuery();


            while (rs1.next()) {
                System.out.println(rs1.getString(1) + "-" +
                        rs1.getString(2) + "-"
                + rs1.getString(3));

            }





            // 접속해제
        }catch(SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();   }
        finally {
            try {con.close();
                System.out.println("연결 해제 성공!"); }
            catch (SQLException e) {}
        }








    }
}
