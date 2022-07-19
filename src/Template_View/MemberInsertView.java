package Template_View;

import DAO.MemberDAO;
import DTO.MemberDTO;

import java.util.Scanner;

public class MemberInsertView implements View {


    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("아이디 입력 : ");
        int id = sc.nextInt();
        System.out.print("암호 입력 : ");
        int password = sc.nextInt();
        System.out.print("이름 입력 : ");
        String name = sc.next();
        System.out.print("폰번호 입력 : ");
        String phone = sc.next();
        System.out.print("이메일 입력 : ");
        String email = sc.next();


        MemberDTO dto = new MemberDTO();
        dto.setId(id);
        dto.setPassword(password);
        dto.setName(name);
        dto.setPhone(phone);
        dto.setEmail(email);

        MemberDAO dao= new MemberDAO();
        int result = dao.insertMember(dto);


        if (result != 0){
        System.out.println("회원가입이 완료되었습니다.");}

    }
}
