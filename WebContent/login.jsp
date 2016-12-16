<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"	import="java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<%
		List<String> info = (List<String>)request.getAttribute("info");
		if(info!=null){
			Iterator<String> iter = info.iterator();
			while(iter.hasNext()){
%>
<h4><%=iter.next() %></h4>
<%
			}
		}
%>
<form action="LoginServlet" method="post" align="center">
			用户名：<input type="text"  name="userid"/><br>
			密码：   <input type="password"   name="userpass"/><br>
			<input type="submit"  value="登录"/>
</form>
<br>
<br>
<div style="width:100%;text-align:center"

><a href="register.jsp"  >注册管理账号</a></div>
</body>
</html>