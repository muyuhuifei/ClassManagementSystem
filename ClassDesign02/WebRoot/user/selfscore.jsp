<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.fonxian.StudentDAO.StudentDao"%>
<%@page import="com.fonxian.StudentDAO.StudentIDao"%>
<%@page import="com.fonxian.StudentDAO.DaoFactory"%>
<%@page import="com.fonxian.Model.studentScore"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人成绩</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<jsp:include page="../inc/head.jsp"/>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
    	StudentDao dao = DaoFactory.getDao();
    	List<studentScore> score = dao.findScore(id);
    %>
    <table border="1px">
    	<tr><td>学生姓名</td><td>课程名</td><td>分数</td><td>任课教师</td></tr>
    <% 
   		for(studentScore i : score){
   	%>
 
   				<tr><td><%=i.getSname() %></td><td><%=i.getCname() %></td><td><%=i.getScore() %></td><td><%=i.getTname() %></td></tr>

   	<%
   		}
     %>
  </body>
</html>
