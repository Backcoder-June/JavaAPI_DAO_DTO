package BackCoder_DAO.DAO_SQL;

import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Service.FindAllService;
import BackCoder_DAO.Service.SearchService;
import BackCoder_DAO.Service.UpdateService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public Member findMe(Member member) {
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

            System.out.println("==마이페이지 정보입니다==");
            System.out.println(
                         "ID:" +  resultSet.getString(1)+", "+
                         "PW:" +resultSet.getString(2)+", "+
                         "이름:" +resultSet.getString(3)+", "+
                         "폰번호:" +resultSet.getString(4)+", "+
                         "이메일:" +resultSet.getString(5)+", "+
                         "가입일:" +resultSet.getString(6)
            );

            //리턴값으로 줄 때.
            member.setName(resultSet.getString(3));
            member.setPhone(resultSet.getString(4));
            member.setEmail(resultSet.getString(5));
            member.setJoindate(resultSet.getString(6));

//            System.out.println("리턴할 멤버정보 : " + member);


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return member;
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

             if (!resultSet.next()) {
                 System.out.println("존재하지 않는 아이디 입니다. 확인 후 다시 시도해 주세요.");
             System.exit(0);}
             else{
//                 resultSet.next();
                 int pwcheck = resultSet.getInt(1);

                 if (pwcheck != member.getPw()) {
                     System.out.println("비밀번호가 일치하지 않아 실행할 수 없습니다. 다시 시도해 주세요.");
                     System.exit(0);
                 }
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

    public List<Member> findAll() {

        Connection con = null;
        ArrayList<Member> memberlist = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL
            String sql =
                    "select * from member";

            PreparedStatement pt = con.prepareStatement(sql);

            ResultSet resultSet = pt.executeQuery();

            memberlist = new ArrayList<>();

            while (resultSet.next()) {
                System.out.println(
                        "이름:" + resultSet.getString(3) + ", " +
                                "이메일:" + resultSet.getString(5) + ", " +
                                "가입일:" + resultSet.getString(6));

                //리턴값으로 줄 용도
                Member memberone = new Member();
                memberone.setName(resultSet.getString(3));
                memberone.setEmail(resultSet.getString(5));
                memberone.setJoindate(resultSet.getString(6));

                memberlist.add(memberone);
            }

            //리턴값으로 뽑기
            System.out.println("멤버 회원 수 : " + memberlist.size() + "명");

            for (Member m: memberlist
                 ) { System.out.println(m.listinfo());}

        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return memberlist;
    }



    //숫자세기
    public int getTotalMember() {

        int totalnumber = 0;

        Connection con = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

            String sql =
                    "select count(*) from member;";

            PreparedStatement pr = con.prepareStatement(sql);

            ResultSet resultSet = pr.executeQuery();

            resultSet.next();
            totalnumber = resultSet.getInt(1);


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return totalnumber;
    }



    public List<Member> pagefindAll() {

        Connection con = null;
        ArrayList<Member> memberlist = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL
            String sql =
                    "select * from member order by regdate limit ?,4";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, (Integer.parseInt(FindAllService.page)-1)*4);

            ResultSet resultSet = pt.executeQuery();

            memberlist = new ArrayList<>();

            while (resultSet.next()) {
                System.out.println(
                        "이름:" + resultSet.getString(3) + ", " +
                                "이메일:" + resultSet.getString(5) + ", " +
                                "가입일:" + resultSet.getString(6));

                //리턴값으로 줄 용도
                Member memberone = new Member();
                memberone.setName(resultSet.getString(3));
                memberone.setEmail(resultSet.getString(5));
                memberone.setJoindate(resultSet.getString(6));

                memberlist.add(memberone);
            }

            //리턴값으로 뽑기
            /*for (Member m: memberlist
            ) { System.out.println(m.listinfo());}
*/
        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return memberlist;
    }



    public List<Member> searchMember(String search) {
        Connection con = null;

        List<Member> list = null;
        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/memberdb", "june", "dnjffl12!@");

//SQL

            String sql =
                    "select * from member where name like ? or email like ?";


            PreparedStatement pr = con.prepareStatement(sql);

            pr.setString(1, "%"+search+"%");
            pr.setString(2, "%"+search+"%");

            ResultSet resultSet = pr.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()){
                Member member = new Member(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5) );

                member.setJoindate(resultSet.getString(6));

                list.add(member);
            }

            System.out.println("해당되는 회원 수 : " + list.size());
            for (Member m :list
                 ) {
                System.out.println(m.listinfo());
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

        return list;
    }







//
}


