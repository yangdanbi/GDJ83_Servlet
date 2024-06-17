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
	<h2 style="text-align: center;">날씨 정보 리스트</h2>
	<table border="1" class="tbl">
		<thead>
			<tr>
				<th>num</th>
				<th>city</th>
				<th>gion</th>
				<th>status</th>
				<th>huminity</th>
			</tr>
		</thead>
		<c:forEach items="${requestScope.list}" var="weather"><!-- list를 담고있는 객체선언 변수명은 weather  -->
			<tbody>
				<tr>
				<!-- 변수명 .num 이니까 list에 있는  num을 가져옴 -->
					<td>${pageScope.weather.num}</td><!-- weather는 var에 써있는 Weather와 동일  -->
					<td><a href="./detail?num=${pageScope.weather.num}">${pageScope.weather.city}</a></td>
					<td>${pageScope.weather.gion}</td>
					<td>${pageScope.weather.status}</td>
					<td>${pageScope.weather.huminity}</td>
				</tr>


			</tbody>
		</c:forEach>

	</table>
	<!-- a태그는 무조건 get타입 -->
	<a href="./add">날씨등록</a>
</body>
</html>