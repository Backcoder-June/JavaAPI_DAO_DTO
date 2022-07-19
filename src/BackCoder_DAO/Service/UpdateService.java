package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Reposit.MemberReposit;

import java.util.Scanner;

public class UpdateService implements MemberReposit {

    public static String update_target = "";
    public static String update_value = "";
    @Override
    public void work() {

        Scanner sc = new Scanner(System.in);

        System.out.println("==회원정보 수정 페이지 입니다==");
        System.out.print("아이디를 입력하세요 : ");
        int id = sc.nextInt();
        System.out.print("패스워드를 입력하세요 : ");
        int pw = sc.nextInt();

        Member member = new Member();
        member.setId(id);
        member.setPw(pw);

        DAO dao = new DAO();
        dao.check(member);


        System.out.print("1. 패스워드 2. 이름 3. 핸드폰번호 4. 이메일 \n 수정할 정보의 번호를 입력 주세요 : ");
        int updatemenu = sc.nextInt();

        if (updatemenu == 1) {
            update_target = "PW";
        } else if (updatemenu == 2) {
            update_target = "name";
        } else if (updatemenu == 3) {
            update_target = "phone";
        } else if (updatemenu == 4) {
            update_target = "email";
        }

        System.out.print("새로운 " + update_target + " : ");
        update_value = sc.next();


        dao.update(member);











    }
}
