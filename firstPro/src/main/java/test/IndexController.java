package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * annotation을 이용하여 controller를 작성하는 경우 메소드를 정의할 때 개발자가 원하는 형태로 메소드 정의 가능
 * 매개변수/리턴타입으로 올 수 있는 타입이 정해져 있음. 하지만 그 안에서 원하는 스펙을 다양하게 적용 가능
 * 리턴타입 : String, void, ModelAndView, ...
 * 			String : 뷰에 대한 정보만 리턴할 때 사용
 * 			ModelAndView : 공유할 데이터와 뷰에 대한 정보를 함께 리턴
 * 매개변수 : String, HttpServletRequest, HttpServletResponse, HttpSession, Model, DTO
 * */

@Controller
public class IndexController{
	
	//우리가 추가한 main() 메소드가 요청될 path를 annotation으로 등록
	//@RequestMapping 안에 정의하는 path는 <bean>의 name 속성에 정의한 path명
	@RequestMapping("/index.do")
	public String main() {
		System.out.println("어노테이션 기반 컨트롤러");
		
		return "test/index";		//View에 대한 정보
	}

}
