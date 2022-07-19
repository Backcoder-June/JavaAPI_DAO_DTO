package Template_View;

import DAO.MemberDAO;
import DTO.MemberDTO;

import java.util.Scanner;

public class MemberDeleteView implements View{


    @Override
    public void input() {

        // 아이디 입력 암호 입력 받고
        //String id, String PW 만 받아라
        // 아이디로 비번 조회해서 일치하면 delete 진행
        // 다르면 암호 확인 하라고 출력

        // 같으면 수행하고 리턴
        // 암호가 다르면 0 리턴

        Scanner sc = new Scanner(System.in);

        System.out.print("아이디 : ");
        int id = sc.nextInt();
        System.out.print("비밀번호 : ");
        int pw = sc.nextInt();


        MemberDAO dao = new MemberDAO();
        dao.deleteMember(id, pw);






    }
}
