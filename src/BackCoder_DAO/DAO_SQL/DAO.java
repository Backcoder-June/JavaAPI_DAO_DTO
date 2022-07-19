package BackCoder_DAO.DAO_SQL;

import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Service.UpdateService;

import java.sql.*;

public class DAO {

    public void join(Member member) {
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

            String sql =
                    "insert into member values(?,?,?,?,?,now())";

            PreparedStatement pr = con.prepareStatement(sql);

            pr.setInt(1,member.getId());
            pr.setInt(2, member.getPw());
            pr.setString(3, member.getName());
            pr.setString(4, member.getPhone());
            pr.setString(5, member.getEmail());

            int executeUpdate = pr.executeUpdate();

            if (executeUpdate != 0) {
                System.out.println("회원가입 완료! 환영합니다!");
            }


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }


    public void update(Member member) {
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL


            String sql = "update member set " +
                    UpdateService.update_target + " = ? where id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, UpdateService.update_value);
            ps.setString(2, String.valueOf(member.getId()));

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate != 0) {
                System.out.println("정보 수정이 완료되었습니다.");
            }



        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }


    public void findMe(Member member) {
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

            String sql =
                    "select * from member where id = ?";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, member.getId());

            ResultSet resultSet = pt.executeQuery();

            resultSet.next();

            System.out.println(
                         "ID:" +  resultSet.getString(1)+", "+
                         "PW:" +resultSet.getString(2)+", "+
                         "이름:" +resultSet.getString(3)+", "+
                         "폰번호:" +resultSet.getString(4)+", "+
                         "이메일:" +resultSet.getString(5)+", "+
                         "가입일:" +resultSet.getString(6)
            );


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }






    public void check(Member member) {
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

            String sql =
                    "select PW from member where id = ?";

            PreparedStatement pr = con.prepareStatement(sql);

            pr.setInt(1, member.getId());

            ResultSet resultSet = pr.executeQuery();

            resultSet.next();

            int pwcheck = resultSet.getInt(1);

            if (pwcheck != member.getPw()) {
                System.out.println("비밀번호가 일치하지 않아 실행할 수 없습니다. 다시 시도해 주세요.");
                System.exit(0);
            }


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }


    public void delete(Member member) {

        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

            String sql =
                    "delete from member where id = ?";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, member.getId());

            int executedelete = pt.executeUpdate();

            if (executedelete != 0) {
                System.out.println("정상적으로 회원탈퇴 되었습니다.");
            }


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }

    public void findAll() {

        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL
            String sql =
                    "select * from member";

            PreparedStatement pt = con.prepareStatement(sql);

            ResultSet resultSet = pt.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                                "이름:" +resultSet.getString(3)+", "+
                                "이메일:" +resultSet.getString(5)+", "+
                                "가입일:" +resultSet.getString(6)
                );
            }




        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }




//
}


