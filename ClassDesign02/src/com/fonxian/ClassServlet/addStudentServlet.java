package com.fonxian.ClassServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fonxian.Model.Student;
import com.fonxian.StudentDAO.DaoFactory;
import com.fonxian.StudentDAO.StudentIDao;

public class addStudentServlet extends HttpServlet {

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
		
		int sid =Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		int stel =Integer.parseInt(request.getParameter("stel"));
		String password = request.getParameter("password");
		int classid =Integer.parseInt(request.getParameter("classid"));
		
		System.out.println("sid"+sid);
		System.out.println("sanme"+sname);
		System.out.println("stel"+stel);
		System.out.println("classid"+classid);
		System.out.println("password"+password);
		
		System.out.println(sname);
		Student stu = new Student();
    	stu.setSid(sid);
    	stu.setSname(sname);
    	stu.setPassword(password);
    	stu.setClassid(classid);
    	stu.setStel(stel);
    	StudentIDao studao = DaoFactory.getDao();
    	studao.addStudent(stu);
    	System.out.println("���ӳɹ�");
    	response.sendRedirect("../admin/listStudentAdmin.jsp");	
	}

}
