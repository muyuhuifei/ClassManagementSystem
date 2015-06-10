<%@page import="com.fonxian.StudentDAO.StudentDao"%>
<%@page import="com.fonxian.StudentDAO.StudentIDao"%>
<%@page import="com.fonxian.StudentDAO.DaoFactory"%>
<%@page import="com.fonxian.Model.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classmatelist.jsp' starting page</title>
    
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
    	<jsp:include page="/inc/head.jsp"/>
    <%
    	StudentDao dao = DaoFactory.getDao();
    	List<Student> stus = dao.findStudent();
    %>
    <table border="1px">
    	<tr><td>学号</td><td>姓名</td><td>手机号码</td><td>班级号</td><td>操作</td></tr>
    <% 
   		for(Student i : stus){
   	%>
   				<tr><td><%=i.getSid() %></td><td><%=i.getSname() %></td><td><%=i.getStel() %></td><td>计算机<%=i.getClassid() %>班</td><td><a href="admin/delStudent.jsp?sid=<%=i.getSid()%>">删除</a>|<a href="updateStudent.jsp?sid=<%=i.getSid() %>">更改</a></td></tr>
   	<%
   		}
     %>
  </body>
</html>
