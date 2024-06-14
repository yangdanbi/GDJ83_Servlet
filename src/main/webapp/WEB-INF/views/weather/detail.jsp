<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>

	</head>

	<body>
		<h2>날씨 한개 정보</h2>
		<h3>${requestScope.dto.city}</h3>
		<h3>${requestScope.dto.gion}</h3>
		<h3>${requestScope.dto.status}</h3>
		<h3>${requestScope.dto.huminity}</h3>
		<!--버튼을 클릭하면 서버로 요청(form url a태그 3개)을 보내서 삭제하기  -->
		<!-- get은 주소창에 직접입력하면 지워지니까 post로 -->
		<!-- readonly 파라미터 값으로 서버에 넘어가지만 disable 은 서버로 넘어가질 않음 -->

		<form id="frm" action="delete" method="post">
		<!--사용자에게 보여줄 필요가 없으니 hidden으로 가림  -->
			<input id = "num" type="hidden" name="num" value="${requestScope.dto.num}" readonly>
		</form>
		<button id="bts">DELETE</button> 

		<script type="text/javascript">
			const btn = document.getElementById("btn");
			const frm = document.getElementById("frm");
			
			bts.addEventListener("click", function () {
				frm.submit();
			//	alert("클릭됨")
			})

		</script>
	</body>

	</html>