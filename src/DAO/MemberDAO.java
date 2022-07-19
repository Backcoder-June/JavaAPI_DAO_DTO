package DAO;

import DTO.MemberDTO;

import java.sql.*;
import java.util.List;

//SQL 을 메소드로 구현하기
public class MemberDAO {

    public int insertMember(MemberDTO dto) {

        int checkrow = 0;
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");
//            System.out.println("연결 완료!");

//SQL
            String sql = "insert into member values(?,?,?,?,?,now())";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, dto.getId());
            pt.setInt(2, dto.getPassword());
            pt.setString(3, dto.getName());
            pt.setString(4, dto.getPhone());
            pt.setString(5, dto.getEmail());

            checkrow = pt.executeUpdate();

            //
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
//                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }

        return checkrow;
    }

    // UPDATE DAO

    public int updateMember(MemberDTO dto) {

        int checkrow = 0;
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

                String colname = "";
                String colvalue = "";

                if (dto.getName() != null) {
                    colname = "name";
                    colvalue = dto.getName();
                } else if (dto.getPhone() != null) {
                    colname = "Phone";
                    colvalue = dto.getPhone();
                } else if (dto.getEmail() != null) {
                    colname = "email";
                    colvalue = dto.getEmail();
                } else if (dto.getPassword() != 0) {
                colname = "PW";
                colvalue = String.valueOf(dto.getPassword()); }


                String updatesql = "update member set " + colname + " = ? where id = ?";

                PreparedStatement ps = con.prepareStatement(updatesql);

                if (colname.equals("PW")) {
                    ps.setInt(1, Integer.parseInt(colvalue));
                } else {
                    ps.setString(1, colvalue);
                }

                ps.setInt(2, dto.getId());


                checkrow = ps.executeUpdate();



            //
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
//                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }

        return checkrow;
    }


    //delete DAO

    public int deleteMember(int id, int pw) {

        int checkrow = 0;
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");
//            System.out.println("연결 완료!");

//SQL


            String findpw = "select PW from member where id = ?";

            PreparedStatement pr = con.prepareStatement(findpw);

            pr.setInt(1, id);

            ResultSet resultSet = pr.executeQuery();

            resultSet.next();

            int pw1 = resultSet.getInt(1);

            if (pw1 == pw) {

                String deletequery =
                        "delete from member where id = ?";

                PreparedStatement pr2 = con.prepareStatement(deletequery);

                pr2.setInt(1, id);

                int updateresult = pr2.executeUpdate();

                if (updateresult != 0) {
                    System.out.println("삭제가 완료되었습니다.");
                }

            } else {
                System.out.println("비밀번호가 일치하지않아 삭제할 수 없습니다.");
            }


            //
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
//                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }

        return checkrow;
    }

    public MemberDTO findMember(MemberDTO dto) {

        int checkrow = 0;
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");
//            System.out.println("연결 완료!");

//SQL

            String sql1 =
                    "select PW from member where id = ?";

            PreparedStatement ps = con.prepareStatement(sql1);

            ps.setInt(1,dto.getId());

            ResultSet resultSet = ps.executeQuery();

            resultSet.next();

            int getpw = resultSet.getInt(1);

            if (getpw == dto.getPassword()) {

                String sql2 =
                        "select * from member where id = ?";
                PreparedStatement ps2 = con.prepareStatement(sql2);

                ps2.setInt(1, dto.getId());

                ResultSet resultSet2 = ps2.executeQuery();

                while (resultSet2.next()) {

                    System.out.println(
                          "아이디 : " +  resultSet2.getString(1) + "\n" +
                                    "비밀번호 : " + resultSet2.getString(2) + "\n" +
                                    "이름 : " + resultSet2.getString(3) + "\n" +
                                    "폰번호 : " + resultSet2.getString(4) + "\n" +
                                    "이메일 : " + resultSet2.getString(5) + "\n" +
                                    "가입날짜 : " + resultSet2.getString(6));
                }
            } else {
                System.out.println("비밀번호가 일치하지 않아 조회할 수 없습니다.");
            }

            //
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
//                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }

        return null;
    }

    public List<MemberDTO> findAllMember() {

        int checkrow = 0;
        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");
//            System.out.println("연결 완료!");

//SQL

            String sql =
                    "select * from member";

            PreparedStatement st = con.prepareStatement(sql);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {

                System.out.println(
                        "아이디 : " +  resultSet.getString(1) + ", " +
                                "이름 : " + resultSet.getString(3) + ", " +
                                "이메일 : " + resultSet.getString(5) + ", " +
                                "가입날짜 : " + resultSet.getString(6));
            }


            //
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
//                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }

        return null;
    }


    public void chekcMember(MemberDTO dto) {

        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");


//SQL
            String findpw = "select PW from member where id = ?";

            PreparedStatement pr = con.prepareStatement(findpw);

            pr.setInt(1, dto.getId());

            ResultSet resultSet = pr.executeQuery();

            resultSet.next();

            int pw1 = resultSet.getInt(1);


            if (pw1 != dto.getPassword()) {
                System.out.println("비밀번호가 틀려 수행할 수 없습니다.");
                System.exit(0);
                }





            //
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
//                System.out.println("연결 해제 성공!");
            } catch (SQLException e) {
            }
        }

    }












//
}










