package shin.spring.mvc.service;

import shin.spring.mvc.vo.SungJukVO;

import java.util.List;

public interface SungJukV13service {

    String newSungJuk(SungJukVO sj);
    List<SungJukVO> readSungJuk();
    SungJukVO readOneSungJuk(String sjno);
    String modifySungJuk(SungJukVO sj);
    String removeSungJuk(String sjno);

}
