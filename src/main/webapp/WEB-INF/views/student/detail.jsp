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
	
	
		<form id="frm" action="delete" method="post">
		<!--사용자에게 보여줄 필요가 없으니 hidden으로 가림  -->
			<input id = "num" type="hidden" name="num" value="${requestScope.dto.num}" readonly>
		</form>
		<button type="button" id="bts">DELETE</button> 
		<button type="button" id="up">UPDATE</button> 

		<script type="text/javascript">
		//둘다 num을 넘길거라 같은 폼 사용
			const btn = document.getElementById("btn");
			const up = document.getElementById("up");
			const frm = document.getElementById("frm");
			//버튼 클릭시 form 전송
			bts.addEventListener("click", function () {
				frm.submit();
			//	alert("클릭됨")
			})
			//메서드 형식을 get으로 변경
			up.addEventListener("click", function () {
				//update 누르면 method action이 바뀜
				//frm.setAttribute("method","get");
				//frm.setAttribute("action","update");
				
				frm.method = "get";
				frm.action="update";
				frm.submit();
				
				
			})

		</script>
	
</body>
</html>