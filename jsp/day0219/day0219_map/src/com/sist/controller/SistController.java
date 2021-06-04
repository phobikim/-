package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.DeleteBookAction;
import com.sist.action.DetailBookAction;
import com.sist.action.InsertBookAction;
import com.sist.action.InsertBookOkAction;
import com.sist.action.ListBookAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBookAction;
import com.sist.action.UpdateBookOkAction;

/**
 * Servlet implementation class SistController
 */

public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, SistAction> map;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
        map = new HashMap<String, SistAction>();
        map.put("listBook.do", new ListBookAction());
        map.put("insertBook.do", new InsertBookAction());
        map.put("insertBookOk.do", new InsertBookOkAction());
        map.put("updateBook.do", new UpdateBookAction());
        map.put("updateBookOk.do", new UpdateBookOkAction());
        map.put("deleteBook.do", new DeleteBookAction());
        map.put("detailBook.do", new DetailBookAction());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pro(request,response);
	}

	private void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		/*
		
			http://localhost:8080/day0219/listBook.do
			http://localhost:8080/day0219/insertBook.do
			http://localhost:8080/day0219/detailBook.do
		
		
			uri = /day0219/listBook.do
			cmd = listBook.do, insertBook.do, detailBook.do
			
			
		*/
		
		
		//사용자가 요청한 서비스명을 파악해요!
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		//updateBook.do
		SistAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}





