<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.* "%>
<%@page import="com.fuzhu.studentmanager.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
	<%
		List<String> info = (List<String>) request.getAttribute("info");
		if (info != null) {
			Iterator<String> iter = info.iterator();
			while (iter.hasNext()) {
	%>
	<h4><%=iter.next()%></h4>
	<%
		}
		}
	%>

	<form action="StudentInformation" method="post">
		根据姓名查询学生信息：<input type="text" name="name" /><br> <input
			type="submit" value="查询" />
	</form>
	<br>
	<br>
	<h3>下面这个思路查询单信息的跟上面是基本一样的，就不写了</h3>
	<form action="StudentInformation" method="post">
		根据ID查询学生信息：<input type="text" name="id" /><br> <input
			type="submit" value="查询" />
	</form>
	<br>
	<br>
	<a href="dataupdate.jsp">去增删改学生信息</a>

	<br>
	<br>
	<a href="SearchAllServlet">查询所有学生信息</a>
	<br>
	<br>

	<%
		List<Student> listAll = (List<Student>) request.getAttribute("list");
		if (listAll != null) {
			Iterator<Student> iterAll = listAll.iterator();
			while (iterAll.hasNext()) {
	%>
	<h4>
		<%
			Student student = (Student) iterAll.next();
		%>
		<%=student.getSTID() %>
		<%=student.getSTNAME() %>
		<%=student.getSTSEX() %>
		<%=student.getSTAGE() %>
		<%=student.getSTPHONE() %>
	</h4>

	<%
		}
		}
	%>
</body>
</html>