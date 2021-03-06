package shin.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    //호출방법 : http://localhost:8080/
    @GetMapping("/") //action메서드
    public String index() {

        // 비지니스 로직 처리

        return "index";  // view리턴
        // 뷰 리졸버 정의문에 의해
        // 머릿말 + 리턴값 + 꼬릿말을 조합해서 뷰 렌더링
        // /WEB-INF/jsp/ + index + .jsp
    }

    //호출방법 : http://localhost:8080/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("hello"); // 뷰 지정
        // /WEB-INF/jsp/ + hello + .jsp

        mv.addObject("msg","Hello,world");
        mv.addObject("msg2","안녕하세요,스프링4");
        mv.addObject("msg3","こんいちは、スプリング");
        // 뷰에 넘길 객체를 modelandview 객체에 담음

        return mv;
    }

}
