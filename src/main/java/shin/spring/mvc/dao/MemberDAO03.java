package shin.spring.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shin.spring.mvc.vo.MemberVO;

import java.util.List;

@Repository("mdao03")
public class MemberDAO03 implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;

    public int insertMember(MemberVO mvo) {return sqlSession.insert("member.insertMember", mvo);}

    public int updateMember(MemberVO mvo) {
        return sqlSession.update("member.updateMember",mvo);
    }

    public int deleteMemeber(String user) {
       return sqlSession.delete("member.deleteMember",user);
    }

    public List<MemberVO> selectMember() {
        return sqlSession.selectList("member.selectList");
    }

    public MemberVO selectOneMember(String user) {return sqlSession.selectOne("member.selectOne" ,user);}

}
