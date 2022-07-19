package Template_View;

import DAO.MemberDAO;
import DTO.MemberDTO;

import java.util.Scanner;

public class MemberFindView implements View{
    @Override
    public void input() {
        // 아이디 암호 받아서 일치하면 조회시켜줌
        // id 존재 pw 존재 별로 구별해서 둘다 있을때만 조회

        Scanner sc = new Scanner(System.in);

        System.out.println("==회원정보 조회입니다.==");
        System.out.print("아이디를 입력하세요 : ");
        int id = sc.nextInt();
        System.out.print("비밀번호를 입력하세요 : ");
        int pw = sc.nextInt();


        MemberDTO dto = new MemberDTO();

        dto.setId(id);
        dto.setPassword(pw);

        MemberDAO dao = new MemberDAO();
        dao.findMember(dto);





    }







}
