package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class TestController  {

	@RequestMapping("/test.do")
	public ModelAndView test() {
		System.out.println("컨트롤러 요청 완료");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", "spring HELLOOOOO");
		
		mav.setViewName("test/result");
		
		return mav;
	}

}
