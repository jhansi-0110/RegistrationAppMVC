<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registered Success</title>
</head>
<body>
	<h1>Registration Successfull</h1>
	<%
	String name=(String)session.getAttribute("name");
	%>
	<h2>Hello <%=name %> , Welcome to Our Website</h2>
	
</body>
</html>