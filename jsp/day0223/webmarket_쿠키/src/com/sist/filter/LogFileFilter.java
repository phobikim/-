package com.sist.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */

public class LogFileFilter implements Filter {

	PrintWriter writer;
	
    /**
     * Default constructor. 
     */
    public LogFileFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		writer.close();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		writer.println("접속한 클라이언트 IP:"+request.getRemoteAddr());
		long start = System.currentTimeMillis();
		writer.println("접근한 URL 경로 : " +  getURLPath(request));
		writer.println("요청 처리 시작 시각:"+ getCurrentTime());
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		writer.println("요청 처리 종료 시각:"+getCurrentTime());
		writer.println("요청 처리 소요 시간:"+(end-start)+"ms");
		writer.println("=================================================================");
		
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
	
	
	
	private String getURLPath(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		String queryString = req.getQueryString();
		queryString = queryString == null?"":"?"+queryString;
		return uri + queryString;
	}
	
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		String filename = fConfig.getInitParameter("filename");
		//String filename = "c:\\logs\\webmarket.log";
		
		if(filename == null) {
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
			
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		}catch (Exception e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
		
	}

}









