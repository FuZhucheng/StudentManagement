<%@page import="com.fuzhu.studentmanager.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		删除的学生名字：<%=request.getAttribute("deletename")%></h3>
	<h3>
		修改的学生名字：<%=request.getAttribute("updatename")%></h3>

	<br>
	<br>
				<h3>修改的学生ID：<%=request.getAttribute("insertstudentID")%></h3>
				<h3>修改的学生姓名：<%=request.getAttribute("insertstudentName")%></h3>
				<h3>修改的学生电话：<%=request.getAttribute("insertstudentPhone")%></h3>
				
				
				<br>
				<br>
				<br>
				<h3>用户已注册：<%=request.getAttribute("registerName")%></h3>
						<a href="login.jsp">去登录刚注册的账号</a>
</body>
</html>