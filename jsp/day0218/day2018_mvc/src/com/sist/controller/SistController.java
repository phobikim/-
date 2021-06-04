package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SistController
 */

public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String url = request.getRequestURL().toString();
		//System.out.println("url:"+url);
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		/*
		
		/day0218_mvc/insertBook.do
		/day0218_mvc/listBook.do
		 * 
		*/
		
		String cmd = uri.substring( uri.lastIndexOf("/") +1);
		System.out.println(cmd);
		
		String viewPage = "";
		if(cmd.equals("listBook.do")) {
			viewPage = "listBook.jsp";
		}else if(cmd.equals("insertBook.do")) {
			viewPage = "insertBook.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
