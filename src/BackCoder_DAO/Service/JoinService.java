package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Reposit.MemberReposit;

import java.util.Scanner;

public class JoinService implements MemberReposit {

        @Override
        public void work() {

            Scanner sc = new Scanner(System.in);

            System.out.println("===회원가입 페이지 입니다===");
            System.out.print("아이디를 입력하세요 : ");
            int id = sc.nextInt();
            System.out.print("패스워드를 입력하세요 : ");
            int pw = sc.nextInt();
            System.out.print("이름을 입력하세요 : ");
            String name = sc.next();
            System.out.print("핸드폰번호를 입력하세요 : ");
            String phone = sc.next();
            System.out.print("이메일을 입력하세요 : ");
            String email = sc.next();


            Member member = new Member(id, pw, name, phone, email);

            DAO dao = new DAO();

            dao.join(member);






        }
    }



