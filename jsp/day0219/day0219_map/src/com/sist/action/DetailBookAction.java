package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;
import com.sist.vo.BookVo;

public class DetailBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		BookDao dao = BookDao.getInstance();
		BookVo b  = dao.getBook(no);
		request.setAttribute("b", b);				
		return "detailBook.jsp";
	}

}
