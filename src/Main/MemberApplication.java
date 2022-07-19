package Main;

import DAO.MemberDAO;
import DTO.MemberDTO;
import Template_View.*;

import java.util.Scanner;

public class MemberApplication {
    public static void main(String[] args) {

        while (true) {

            System.out.println("=== 회원 관리 프로그램을 시작 합니다. ===");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원정보 수정");
            System.out.println("3. 회원 탈퇴");
            System.out.println("4. 내정보 조회");
            System.out.println("5. 회원 리스트 조회");
            System.out.println("6. 종료");
            System.out.print("원하는 메뉴의 번호를 입력하세요 : ");

            Scanner sc = new Scanner(System.in);
            int menu = sc.nextInt();

            if (menu == 6) { System.exit(0);}
            else if (menu ==1){
                MemberInsertView insert = new MemberInsertView();
                insert.input();
            } else if (menu == 2) {
                MemberUpdateView update = new MemberUpdateView();
                update.input();
            } else if (menu == 3) {
                MemberDeleteView delete = new MemberDeleteView();
                delete.input();
            } else if (menu == 4) {
                MemberFindView find = new MemberFindView();
                find.input();
            } else if (menu == 5) {
                MemberFindAllView findall = new MemberFindAllView();
                findall.input();
            }



        }



    }
}
