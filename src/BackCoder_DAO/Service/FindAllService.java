package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Entity.Member;
import BackCoder_DAO.Reposit.MemberReposit;

import java.util.List;
import java.util.Scanner;

public class FindAllService implements MemberReposit {

    public static String page = "";
    @Override
    public void work() {

        DAO dao = new DAO();

        int totalcount = dao.getTotalMember();
        int pagepernum = 4;

        int totalpage =0;
        if (totalcount % pagepernum == 0) {
            totalpage = totalcount / pagepernum;
        }else {
            totalpage = totalcount / pagepernum + 1;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("==회원정보 조회 페이지 입니다==");
        System.out.println("(전체회원을 조회하려면 * 를 입력해주세요)");
        System.out.print("조회할 페이지를 입력해 주세요.( 1 ~ " + totalpage + " ) : ");

         page = sc.next();

        if (page.equals("*")){
            List<Member> allmember = dao.findAll();
        }else {
            dao.pagefindAll();
        }




    }
}
