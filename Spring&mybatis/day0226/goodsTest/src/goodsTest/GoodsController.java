package goodsTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {

	private GoodsDao dao;
	
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listGoods.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		mav.setViewName("listGoods");
		//   /WEB-INF/view/listGoods.jsp
		return mav;
	}
}







