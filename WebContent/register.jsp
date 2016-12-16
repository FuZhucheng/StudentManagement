<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="RegisterServlet" method="post">
			注册管理者账号：<br>
			用户ID   <input type="text"  name="userid"/><br>
			用户名：<input type="text"  name="name"/><br>
			密码：<input type="text"  name="password"/><br>
			<input type="submit"  value="增加"/>
</form>
</body>
</html>