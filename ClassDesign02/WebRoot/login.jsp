<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <form action="" method="post">
    	<table>
    		<tr>
    			<td>账号</td>
    			<td>
    				<input type="text" name="username"></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td>
    				<input type="password" name="password"></td>
    		</tr>
    	</table>
    	<fieldset data-role="controlgroup" id="radio-1"
    		data-type="horizontal">
    		<legend></legend>
    		<input name="radio-choice-1" id="radio-choice-1a"
    			data-mini="true" value="学生登录" type="radio" />
    		<label for="radio-choice-1a">学生登录</label>
    		<input name="radio-choice-1" id="radio-choice-1b"
    			data-mini="true" value="管理员登录" type="radio" />
    		<label for="radio-choice-1b">管理员登录</label>
    	</fieldset>
    	<input type="submit" value="提交" />
    </form>
  </body>


</html>
