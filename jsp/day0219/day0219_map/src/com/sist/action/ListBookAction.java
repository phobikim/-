package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDao;
import com.sist.vo.BookVo;

public class ListBookAction implements SistAction {
	
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookDao dao = BookDao.getInstance();
		ArrayList<BookVo> list = dao.findAll();
		request.setAttribute("list", list);
		return "listBook.jsp";
	}
	

}








