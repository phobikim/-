package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;
import com.sist.vo.BookVo;

public class InsertBookOkAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		BookVo b = new BookVo();		
		b.setNo(Integer.parseInt(request.getParameter("no")));
		b.setName(request.getParameter("name"));
		b.setPublisher(request.getParameter("publisher"));
		b.setPrice(Integer.parseInt(request.getParameter("price")));
		
		BookDao dao = BookDao.getInstance();
		int re = dao.insert(b);
		String msg = "도서 등록에 성공하였습니다.";
		if(re != 1) {
			msg = "도서 등록에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		
		return "insertBookOk.jsp";
	}

}





