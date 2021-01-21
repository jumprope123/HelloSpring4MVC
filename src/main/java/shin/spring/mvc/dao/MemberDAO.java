package shin.spring.mvc.dao;

import shin.spring.mvc.vo.MemberVO;
import java.util.List;

public interface MemberDAO {

    int insertMember(MemberVO mvo);

    int updateMember(MemberVO mvo);

    int deleteMemeber(String name);

    List<MemberVO> selectMember();

    MemberVO selectOneMember(String user);
}
