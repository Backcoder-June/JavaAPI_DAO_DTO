package BackCoder_DAO;

import BackCoder_DAO.Service.*;

import java.util.Scanner;

public class RebootApplication {
    public static void main(String[] args) {


        while (true) {

            System.out.println("=== 회원 관리 프로그램을 시작 합니다. ===");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원정보 수정");
            System.out.println("3. 회원 탈퇴");
            System.out.println("4. 내정보 조회");
            System.out.println("5. 회원 리스트 조회");
            System.out.println("6. 회원 검색 조회");
            System.out.println("0. 종료");
            System.out.print("원하는 메뉴의 번호를 입력하세요 : ");

            Scanner sc = new Scanner(System.in);

            int menu = sc.nextInt();

            if (menu == 0) {
                System.out.println("이용해 주셔서 감사합니다!");
                System.exit(0);
            } else if (menu == 1) {
                JoinService joinService = new JoinService();
                joinService.work();
            } else if (menu == 2) {
                UpdateService updateService = new UpdateService();
                updateService.work();
            }  else if (menu == 3) {
                DeleteService deleteService = new DeleteService();
                deleteService.work();
            } else if (menu == 4) {
                FindmeService findmeService = new FindmeService();
                findmeService.work();
            } else if (menu == 5) {
                FindAllService findAllService = new FindAllService();
                findAllService.work();
            } else if (menu == 6) {
                SearchService searchService = new SearchService();
                searchService.work();
            }









        }





    }
}
