<%@page import="com.fonxian.StudentDAO.DaoFactory"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.fonxian.StudentDAO.StudentDao"%>
<%@ page language="java" import="com.fonxian.StudentDAO.StudentIDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delStudent.jsp' starting page</title>
    
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
  	int sid = Integer.parseInt(request.getParameter("sid"));
  	StudentDao studao = DaoFactory.getDao();
  	studao.delStudent(sid);
  	response.sendRedirect("listStudent.jsp");
   %>
  <body>
    <h1>删除成功</h1>
    
  </body>
</html>
