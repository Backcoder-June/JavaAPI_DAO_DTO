package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Reposit.MemberReposit;

import java.util.Scanner;

public class DeleteService implements MemberReposit {
    @Override
    public void work() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==회원탈퇴 페이지 입니다==");
        System.out.print("아이디를 입력하세요 : ");
        int id = sc.nextInt();
        System.out.print("패스워드를 입력하세요 : ");
        int pw = sc.nextInt();

        Member member = new Member();
        member.setId(id);
        member.setPw(pw);

        DAO dao = new DAO();
        dao.check(member);


        System.out.print("회원 탈퇴를 진행하시려면 1번, 서비스를 계속 이용하시려면 2번을 입력해 주세요. : ");
        int choice = sc.nextInt();
        if (choice == 1) {
            dao.delete(member);
        } else if (choice == 2) {
            System.out.println("회원탈퇴가 취소되었습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");}



    }
}
