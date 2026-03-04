<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>KT</h1>
<%
	String tenDN = request.getParameter("tenDN");
	String MK = request.getParameter("mk");
	if(tenDN.equals("ABC") && MK.equals("MNK"))
	{
		response.sendRedirect("UserProfile.html");
	}
	else
		response.sendRedirect("Login.html");
%>
</body>
</html>