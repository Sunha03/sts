package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//기본 web에서 작성하던 서블릿과 동일한 역할을 하는 클래스
//컨트롤러
//- DispatcherServlet에서 호출되는 클래스
//- 서블릿에서 했던 것처럼 DAO의 메소드를 호출
//- 데이터 공유(spring의 방법대로)
public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("컨트롤러 요청 완료");
		
		//공유 데이터 정보 & 응답뷰에 대한 정보를 담고 있는 spring 객체
		ModelAndView mav = new ModelAndView();
		
		//공유 데이터 저장
		// = request.setAttribute("msg", "spring 컨트롤러에서 넘긴 데이터")
		mav.addObject("msg", "spring 컨트롤러에서 넘긴 데이터");
		
		//forward할 뷰의 정보를 정의(forward가 default)
		mav.setViewName("test/result");
		
		return mav;
	}

}
