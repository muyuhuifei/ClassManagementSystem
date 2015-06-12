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
		
//		Map<String,String> errorMsg = new HashMap<String,String>();
//		if(request.getParameter("sid") == null)
//			errorMsg.put(sid, "sid"+"'不能为空");

		int sid =Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		int stel =Integer.parseInt(request.getParameter("stel"));
		int classid =Integer.parseInt(request.getParameter("classid"));
		
		System.out.println(sid);
		System.out.println(sname);
		System.out.println(stel);
		System.out.println(classid);
		
		System.out.println(sname);
		Student stu = new Student();
    	stu.setSid(sid);
    	stu.setSname(sname);
    	stu.setClassid(classid);
    	stu.setStel(stel);
    	StudentIDao studao = DaoFactory.getDao();
    	studao.addStudent(stu);
    	System.out.println("添加成功");
    	response.sendRedirect("../admin/listStudentAdmin.jsp");	
	}

}
