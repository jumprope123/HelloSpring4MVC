package shin.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shin.spring.mvc.dao.MemberDAO;
import shin.spring.mvc.dao.MemberDAO03;
import shin.spring.mvc.vo.MemberVO;
import java.util.List;

@Service("msrv04")
public class MemberService04 implements MemberService{

    @Autowired
    private MemberDAO mdao03;

    //회원 정보 생성
    public String newMember(MemberVO mvo){
        String result = "입력 실패!";
        int cnt = mdao03.insertMember(mvo);
        if (cnt>0){
            result = "입력 성공!";
        }
        return result;
    }

    // 회원 정보 수정 (이름 등급 포인트)
    public String modifyMember(MemberVO mvo) {
        String result = "수정 실패!";
        int cnt = mdao03.updateMember(mvo);
        if (cnt > 0){
            result = "수정 성공";
        }
        return result;
    }

    //회원 정보 삭제 (일지매로 검색해서)
    String result = "수정 실패!";
    public String removeMember(String user) {
       int cnt = mdao03.deleteMemeber(user);
        if (cnt > 0){
            result = "수정 성공";
        }
        return result;
    }

    //회원정보 조회(아이디,등급,가입일)
    public List<MemberVO> readMember() {

        return mdao03.selectMember();
    }

    //회원정보 상세조회(아이디로 검색)
    public MemberVO readOneMember(String user) {
        return mdao03.selectOneMember(user);

    }
}
