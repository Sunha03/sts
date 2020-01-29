package exam.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//메뉴 화면을 선택 > 화면 교체해주는 컨트롤러
//컨트롤러에 처리할 메소드를 여러 개 등록해서 사용 가능 > 비슷한 기능을 처리하는 경우
@Controller
public class TilesIndexController {
	@RequestMapping("/exam/index.do")
	public String index() {
		return "index";			//tiles 설정 파일에 등록된 view의 이름
	}
	
	@RequestMapping("/menu/mybatis.do")
	public String mybatisView() {
		return "menu/mybatis";		//tiles에 등록된 menu/mybatis를 기준으로 뷰를 만들기
	}
	
	@RequestMapping("/menu/advanced.do")
	public String advancedView() {
		return "menu/advanced";
	}
}
