package shin.spring.mvc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import shin.spring.mvc.service.SungJukV13service;
import shin.spring.mvc.vo.SungJukVO;

// URL          View
// ~/sungjuk (sungjuk.jsp)
// ~/sungjukok (sungjukok.jsp)
// ~/sungjuklist (sungjuklist.jsp)
// ~/sungjukview (sungjukview.jsp)



@Controller
public class SungJukController {

    @Autowired
    private SungJukV13service sjsrv13;

    // 성적 입력 폼 출력
    @GetMapping("/sungjuk")
    public String sungjuk(){
        return "sungjuk";
    }

    // 성적 입력 처리 (post방식으로 요청시 호출됨)
    // 주소창에 쳐서는 검색이 안됨
    // 성적입력 폼에 입력한 내용들은 스프링 컨테이너에 의해
    // SungJukVO의 멤버변수에 자동으로 저장 됨
    // 단, form의 각 변수명과 SungJukVO의 멤버변수명은 일치해야 함
    // ~/sungjuk -> ~/sungjukok -> sjsrv13 -> sjdao12
    //     view          WAS        service    DAO
    @PostMapping("/sungjukok")
    public ModelAndView sungjukok(SungJukVO sjvo){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjukok");
        mv.addObject("result", sjsrv13.newSungJuk(sjvo));
        mv.addObject("sj", sjvo);
        return mv;

    }

    // 성적 데이터 조회
    // 학생 번호, 이름, 국어, 영어, 수학, 등록일 형태 출력
    // ~/sungjuklist -> sjsrv13 -> sjdao12  -> db
    //     view          service    DAO
    @GetMapping("/sungjuklist") // 성적조회
    public ModelAndView sungjuklist(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjuklist");
        mv.addObject("sjlist",sjsrv13.readSungJuk());
        return mv;
    }

    // sungjuklist.jsp에서 학생이름을 클릭하면 학생번호sjno를 전송
    @GetMapping("/sungjukview")
    public ModelAndView sungjukview(String sjno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjukview");
        mv.addObject("sj",sjsrv13.readOneSungJuk(sjno));
        return mv;
    }

    //성적번호를 이용해서 지정한 성적데이터를 삭제함
    @GetMapping("/sungjukdel")
    public String sungjukdel(String sjno){

        System.out.println(sjsrv13.removeSungJuk(sjno));

        // 성적 데이터를 삭제하고 난 뒤 /sungjuklist로 바로 이동
        return "redirect:/sungjuklist";
    }

    // 성적 번호를 이용해서 수정할 성적 데이터를 읽어와서
    // sungjukupd.jsp에 출력함
    @GetMapping("/sungjukupd")
    public ModelAndView sungjukupd(String sjno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjukupd");
        mv.addObject("sj",sjsrv13.readOneSungJuk(sjno));

        return mv;
    }

    // 수정할 데이터를 전송받아서
    // sungjuk테이블에 적용하고 sungjuklist로 redirect함
    @PostMapping("/sungjukupdok")
    public String sungjukupdok(SungJukVO sj){
        System.out.println(sjsrv13.modifySungJuk(sj));
        // 특정메서드에서 return한 결과를 콘솔에서 확인가능
        return "redirect:/sungjuklist";
    }

}
