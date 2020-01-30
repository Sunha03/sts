package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/*	/index.do로 요청 > 'index'라는 이름의 뷰를 forward
	 * 	> index라는 뷰는 내 스프링 설정 파일에 등록된 ViewResolver에 따라 다르게 작성됨
	 */
	@RequestMapping("/index.do")
	public String main() {
		return "index";
	}
}
