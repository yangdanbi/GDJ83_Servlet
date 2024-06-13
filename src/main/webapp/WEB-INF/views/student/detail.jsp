<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 한명 정보</h1>
	<!--  표현식 -->

	<!--EL  표현언어-->
	<%-- ${스코프영역.속성명} --%>
	<%-- <h3>${requestScope.avg}</h3> --%>
	<!--꺼낼때는 getter에 이름을 씀 - get을빼고 첫글자를 소문자로 바꾼것  -->
	<!--꺼낼때는 getter에 이름을 씀 - set을빼고 첫글자를 소문자로 바꾼것  -->
 	<h3>${requestScope.dto.num}</h3>
	<h3>${requestScope.dto.name}</h3>
	<h3>${requestScope.dto.kor}</h3>
	<h3>${requestScope.dto.eng}</h3>
	<h3>${requestScope.dto.math}</h3>
	<h3>${requestScope.dto.total}</h3>
	<h3>${requestScope.dto.avg}</h3> 
	
</body>
</html>