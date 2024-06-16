<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>학생 리스트</h1>
	<div>
		<img alt="" src="/resources/images/dog2.jpg">
	</div>
	<table border="1" class ="tbl">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Kor</th>
				<th>Eng</th>
				<th>Math</th>
				<th>Total</th>
				<th>Avg</th>
				
			</tr>
		</thead>
		<c:forEach items="${requestScope.list}" var="student">
		<tbody>
			<tr>
				<td><a href="./detail?num=${pageScope.student.num}">${pageScope.student.num}</a></td>
				<td>${pageScope.student.name}</td>
				<td>${pageScope.student.kor}</td>
				<td>${pageScope.student.eng}</td>
				<td>${pageScope.student.math}</td>
				<td>${pageScope.student.total}</td>
				<td>${pageScope.student.avg}</td>
			</tr>
			

		</tbody>
	</c:forEach>

	</table>
	<a href="./add">학생등록</a>
<%-- 	<c:forEach items="${requestScope.list}" var="student">

		<h3>번호 : ${pageScope.student.num}</h3>
		<h3>이름 : ${pageScope.student.name}</h3>
		<h3>평균 : ${pageScope.student.avg}</h3>
		<hr>
	</c:forEach> --%>
</body>
</html>