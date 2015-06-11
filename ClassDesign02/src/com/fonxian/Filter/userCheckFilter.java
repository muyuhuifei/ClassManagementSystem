package com.fonxian.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fonxian.Model.Student;

public class userCheckFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		System.out.println("À¹½Ø1");
		Student stu = (Student)session.getAttribute("loginUser");
		System.out.println("À¹½Ø2");
		if(stu == null){
			response.sendRedirect(request.getContextPath()+"/"+"login.jsp");
			return;
		}
		System.out.println("À¹½Ø4");
		chain.doFilter(req, resp);
		System.out.println("À¹½Ø5");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
