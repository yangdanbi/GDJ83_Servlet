<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DB Page</h1>


	<%
	//java 
	//스크립트릿
	int num = 10;
	num = num * 2;
	%>
	
	<h3><%=num%></h3>
	<!-- 표현식 -->
	
	
	<%for (int i = 0; i < 10; i++) {%>
	
	<%=i %>
	
	<%}%>


</body>
</html>