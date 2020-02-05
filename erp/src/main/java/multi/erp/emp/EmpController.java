package multi.erp.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//emp 테이블에서 작업하는 모든 내용에 대한 컨트롤러
@Controller
public class EmpController {
	
	@Autowired
	EmpServiceImpl service;
	
	//로그인 페이지
	@RequestMapping(value="/emp/login.do", method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	//실제 로그인 동작
	//MemberVO loginUserInfo
	// >> spring MVC내부의 클래스인 DispatcherServlet에서 자동으로 입력된 파라미터들을 추출 &
	//	  VO 객체를 만들고 setter메소드의 값으로 전달
	@RequestMapping(value="/emp/login.do", method=RequestMethod.POST)
	public ModelAndView login(MemberVO loginUserInfo, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		//user : DB연동 후 로그인된 사용자의 정보
		//loginUserInfo : 로그인하기 위해 사용자가 입력한 데이터를 VO로 만든 객체
		MemberVO user = service.login(loginUserInfo);
		
		//로그인한 사용자의 정보 > 세션에 저장
		//세션을 사용하기 위해 매개변수에 HttpServletRequest를 정의
		String viewName = "";
		if(user != null) {			//로그인 성공
			//1. 세션을 생성 > getSession()를 이용해 세션 생성
			//			  > 무조건 생성해서 리턴(처음 세션 만들 때 사용)
			HttpSession ses = request.getSession();
			
			//2. 세션에 데이터 공유
			ses.setAttribute("user", user);
			viewName = "login/ok";
		} else {					//로그인 실패
			viewName = "login";
		}
		
		mav.setViewName(viewName);
		
		System.out.println(user.toString());
		
		return mav;
	}
	
	@RequestMapping("/emp/logout.do")
	public String logout(HttpSession session) {		//로그아웃
		//사용하던 세션 객체가 있으면 > 사용하던 세션 객체가 전달됨
		if(session != null) {		//세션 존재 > 세션 객체 해제
			session.invalidate();
		}
		
		return "redirect:/index.do";
	}
	
	@RequestMapping("/emp/insertView.do")
	public String insertView() {
		return "emp/insert";
	}
	
	/*@RequestMapping("/emp/idcheck.do")		//전체 페이지 다시 불러오기(동기 요청)
	public ModelAndView idCheck(String id) {
		ModelAndView mav = new ModelAndView();
		boolean state = service.idCheck(id);
		String result = "";
		
		if(state) {		//이미 사용자가 존재 > DB에 해당 아이디가 있음
			result = "불사용가능한 아이디";
		} else {		//새로운 아이디
			result = "사용가능한 아이디";
		}
		
		mav.addObject("info", result);
		mav.setViewName("emp/insert");
		
		return mav;
	}*/
	
	//ajax 요청(비동기 통신)
	//produces 속성 : ajax 요청 후 클라이언트로 전송할 데이터의 타입을 정의
	//				 application/text는 Ajax 요청 후 클라이언트로 보내는 응답 메세지의 타입 => text
	@RequestMapping(value="/emp/idcheck.do", method=RequestMethod.GET, 
						produces="application/text;charset=utf-8")
	public @ResponseBody String idCheck(String id) {
		boolean state = service.idCheck(id);
		String result = "";
		
		if(state) {		//이미 사용자가 존재 > DB에 해당 아이디가 있음
			result = "불사용가능한 아이디";
		} else {		//새로운 아이디
			result = "사용가능한 아이디";
		}
		
		return result;
	}
}
