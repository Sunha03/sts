package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController{

	@RequestMapping("/index.do")
	protected ModelAndView index() {
		return new ModelAndView("test/index");
	}

}
