<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.fonxian.Model.Student"%>
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
    
    <title>添加学生</title>
    
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
  	
    <%
    	Student stu = new Student();
    	stu.setSid(1205);
    	stu.setSname("文雄");
    	stu.setClassid(1);
    	stu.setStel(1234);
    	StudentIDao studao = new StudentDao();
    	studao.addStudent(stu);
    	out.println("添加成功");
     %>
 
</body>
</html>
