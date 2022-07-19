package Service_View;

import DAO.MemberDAO;

public class MemberFindAllView implements View{
    @Override
    public void input() {

        System.out.println("==전체 회원목록 조회입니다.");

        MemberDAO dao = new MemberDAO();

        dao.findAllMember();

    }
}
