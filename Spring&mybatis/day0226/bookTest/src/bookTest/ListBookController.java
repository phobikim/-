package bookTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BookDao;

@Controller
public class ListBookController {

	private BookDao dao;
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBook.do")
	public   ModelAndView    list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "도서목록");
		mav.addObject("list", dao.findAll());
		
		mav.setViewName("listBook");
		
		
		// /WEB-INF/view/listBook.jsp
		return mav;
	}
}










