package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Reposit.MemberReposit;

import java.util.Scanner;


public class SearchService implements MemberReposit {

    @Override
    public void work() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==회원정보 검색 페이지 입니다==");
        System.out.print("검색할 회원정보를 입력해 주세요. \n회원정보 : ");
        String search = sc.nextLine();

        DAO dao = new DAO();

        dao.searchMember(search);

    }
}
