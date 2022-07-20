package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Reposit.MemberReposit;

import java.util.Scanner;

public class FindmeService implements MemberReposit {
    @Override
    public void work() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==마이페이지 서비스 입니다==");
        System.out.print("아이디를 입력하세요 : ");
        int id = sc.nextInt();
        System.out.print("패스워드를 입력하세요 : ");
        int pw = sc.nextInt();

        Member member = new Member();
        member.setId(id);
        member.setPw(pw);


        DAO dao = new DAO();

        dao.check(member);

        dao.findMe(member);



    }
}
