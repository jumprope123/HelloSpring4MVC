package shin.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import shin.spring.mvc.service.MemberService;
import shin.spring.mvc.vo.MemberVO;

@Controller
public class memberController {

    @Autowired
    private MemberService msrv4;

    @GetMapping("/member")
    public String member(){
        return "member";
    }

    @PostMapping("/memberok")
    public ModelAndView memberok(MemberVO mvo){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberok");
        mv.addObject("result", msrv4.newMember(mvo));
        mv.addObject("mvo",mvo);
        return mv;
    }

    @GetMapping("/memberlist")
    public ModelAndView memberlist(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberlist"); // WEB-INF/jsp/memberlist.jsp 호출
        mv.addObject("mvos",msrv4.readMember());
        return mv;
    }

    @GetMapping("/memberview")
    public ModelAndView memberview(String user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberview");
        mv.addObject("mvo",msrv4.readOneMember(user));

        return mv;
    }

    @GetMapping("/memberupd")
    public ModelAndView memberupd(String user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberupd");
        mv.addObject("mvo", msrv4.readOneMember(user));
        return mv;
    }

    @PostMapping("/memberupdok")
    public String memberupdok(MemberVO mvo){
        msrv4.modifyMember(mvo);
        return "redirect:/memberlist";
    }

    @GetMapping
    public String memberdel(String user){
        msrv4.removeMember(user);
        return "redirect:/memberlist";
    }
}
