package com.fonxian.ClassServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fonxian.Model.Student;
import com.fonxian.StudentDAO.DaoFactory;
import com.fonxian.StudentDAO.StudentIDao;

public class updateStudentUserServlet extends HttpServlet {

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

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		int sid =Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		int stel =Integer.parseInt(request.getParameter("stel"));
		int classid =Integer.parseInt(request.getParameter("classid"));
		String password = request.getParameter("password");
		
		
		System.out.println(sname);
		Student stu = new Student();
    	stu.setSid(sid);
    	stu.setSname(sname);
    	stu.setClassid(classid);
    	stu.setStel(stel);
    	stu.setPassword(password);
    	StudentIDao studao = DaoFactory.getDao();
    	studao.updateStudent(stu);;
    	System.out.println("更新成功");
    	HttpSession session = request.getSession();
    	session.setAttribute("loginUser", stu);
    	response.sendRedirect("../user/selfInfo.jsp");	
	}

}
