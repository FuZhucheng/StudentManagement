<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增删改学生数据</title>
</head>
<body>
<form action="DataUpdateServlet" method="post">
			根据姓名删除学生信息：<input type="text"  name="delete_name"/><br>
			<input type="submit"  value="删除"/>
</form>
<br>
<br>
<form action="DataUpdateServlet" method="post">
			增加学生：<br>
			ID   <input type="text"  name="STID"/><br>
			姓名：<input type="text"  name="STNAME"/><br>
			性别：<input type="text"  name="STSEX"/><br>
			年龄：<input type="text"  name="STAGE"/><br>
			电话：<input type="text"  name="STPHONE"/><br>
			<input type="submit"  value="增加"/>
</form>
<br>
<br>
<form action="DataUpdateServlet" method="post">
			更改学生姓名：<br>
			要更名的学生名字<input type="text"   name="proviousName"/><br>
			名字更改为：<input type="text"  name="nowName"/><br>
			<input type="submit"  value="更改"/>
</form>
</body>
</html>