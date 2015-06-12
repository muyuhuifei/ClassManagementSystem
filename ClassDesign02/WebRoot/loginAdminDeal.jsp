<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.fonxian.StudentDAO.StudentDao"%>
<%@page import="com.fonxian.StudentDAO.StudentIDao"%>
<%@page import="com.fonxian.StudentDAO.DaoFactory"%>
<%@page import="com.fonxian.Model.Student"%>
<%@page import="com.fonxian.Model.Teacher"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	int tid = Integer.parseInt(request.getParameter("loginAdminName"));
  	String password  = request.getParameter("loginAdminPassword");
  	StudentIDao dao = DaoFactory.getDao();
    Teacher teacher = dao.loginAdmin(tid, password);
    System.out.println("name:"+teacher.getTname());
    session.setAttribute("loginAdmin", teacher);
    response.sendRedirect(request.getContextPath()+"/"+"admin/introduce.jsp");
   %>
  <body>
    
  </body>
</html>
