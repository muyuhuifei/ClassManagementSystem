<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStudent.jsp' starting page</title>
    
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
  	<jsp:include page="../inc/head.jsp">
  	  		<jsp:param value="Add" name="op"/>
	</jsp:include>
    <form action="/ClassDesign02/servlet/addStudentServlet" method="post">
    	<table>
    		<tr><td>学生学号</td><td><input type="text" name="sid"/></td></tr>
    		<tr><td>学生姓名</td><td><input type="text" name="sname"/></td></tr>
    		<tr><td>手机号码</td><td><input type="text" name="stel"/></td></tr>
    		<tr><td>班 级</td><td><select name="classid"><option value="1">计算机1班</option><option value="2">计算机2班</option><option value="3">计算机3班</option><option value="4">计算机4班</option></select></td></tr>
    		<tr><td><input type="submit" value="提交"></td></tr>
    	</table>
    </form>
  </body>
</html>
