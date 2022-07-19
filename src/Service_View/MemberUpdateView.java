package Service_View;

import DAO.MemberDAO;
import DTO.MemberDTO;

import java.util.HashMap;
import java.util.Scanner;

public class MemberUpdateView implements View{

    public static String update_target = "";


    @Override
    public void input() {

        // 아이디 입력 받고
        // 수정항목 : 암호 / 이름 / 폰번 / 이메일 선택하세요 (입력받고)
        // 수정값 입력 받고

        // 멤버DTO 객체 생성
        // 입력받은 값만 있으면 됨. update 문 쓸거니까

        Scanner sc = new Scanner(System.in);
        System.out.println("== 회원정보 수정 페이지 입니다 ==");
        System.out.print("아이디를 입력하세요 : ");
        int updateId = sc.nextInt();
        System.out.print("비밀번호를 입력하세요 : ");
        int updatePW = sc.nextInt();

        MemberDTO dto = new MemberDTO();
        dto.setId(updateId);
        dto.setPassword(updatePW);

        MemberDAO dao = new MemberDAO();

        dao.chekcMember(dto);


        System.out.print("수정할 항목의 번호를 입력하세요.\n" +
                "1. 암호  2. 이름  3. 폰번호  4. 이메일 \n" +
                " 수정할 항목 번호 : ");
        int updateNum = sc.nextInt();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "암호");
        map.put(2, "이름");
        map.put(3, "폰번호");
        map.put(4, "이메일");

        System.out.print("새로운 " + map.get(updateNum) + " : " );
        String updateInput = sc.next();



        if (updateNum == 1) {
            dto.setPassword(Integer.parseInt(updateInput));
        } else if (updateNum == 2) {
            dto.setName(updateInput);
        } else if (updateNum == 3) {
            dto.setPhone(updateInput);
        } else if (updateNum == 4) {
            dto.setEmail(updateInput);
        }



        int updateResult = dao.updateMember(dto);

        if (updateResult != 0) {
            System.out.println("수정이 완료되었습니다.");
        }


    }


}
/*

        switch (updateNum) {
            case 1 : dto.setPassword(Integer.parseInt(updateInput));
            case 2 : dto.setName(updateInput);
            case 3 : dto.setPhone(updateInput);
            case 4 : dto.setEmail(updateInput);
        }
*/
        /*switch (updateNum) {
            case 1 : update_target = "PW";
            case 2 : update_target = "name";
            case 3 : update_target = "phone";
            case 4 : update_target = "email";
        }
*/
