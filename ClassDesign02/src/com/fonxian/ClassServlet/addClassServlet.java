package com.fonxian.ClassServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fonxian.Model.Course;
import com.fonxian.StudentDAO.DaoFactory;
import com.fonxian.StudentDAO.StudentIDao;

public class addClassServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int cid =Integer.parseInt(request.getParameter("cid"));
		String cname = request.getParameter("cname");
		int tid =Integer.parseInt(request.getParameter("tid"));

		
		System.out.println("sid"+cid);
		System.out.println("sanme"+cname);
		System.out.println("stel"+tid);

		
		System.out.println(cname);
		Course course = new Course();
    	course.setCid(cid);
    	course.setCname(cname);
    	course.setTid(tid);
    	StudentIDao studao = DaoFactory.getDao();
    	studao.addCourse(course);
    	System.out.println("Ìí¼Ó³É¹¦");
    	response.sendRedirect("../admin/listClassAdmin.jsp");	
	}

}
