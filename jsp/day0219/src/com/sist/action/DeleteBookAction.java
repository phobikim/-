package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;

public class DeleteBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BookDao dao = BookDao.getInstance();
		int re = dao.deleteBook(no);
		String msg = "도서를 삭제하였습니다.";
		if(re !=  1) {
			msg = "도서 삭제에 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		
		return "deleteBookOk.jsp";
	}

}
