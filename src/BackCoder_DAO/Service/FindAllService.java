package BackCoder_DAO.Service;

import BackCoder_DAO.DAO_SQL.DAO;
import BackCoder_DAO.Reposit.MemberReposit;

public class FindAllService implements MemberReposit {
    @Override
    public void work() {
        System.out.println("==멤버쉽 회원 목록 서비스 입니다==");

        DAO dao = new DAO();
        dao.findAll();
    }
}
