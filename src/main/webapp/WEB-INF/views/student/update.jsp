<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 수정페이지</h2>
	<form action="./update" method="post">
		<div>
			<input type="hidden" name="num" value="${dto.num}">
		</div>
		<div>
			<label>이름</label>
			 <input type="text" name="name" value="${dto.name}">
		</div>
		<div>
			<label>국어점수</label>
			 <input type="text" name="kor" value="${dto.kor}">
		</div>
		<div>
			<label>영어점수</label>
			 <input type="text" name="eng" value="${dto.eng}">
		</div>
		<div>
			<label>수학점수</label> 
			<input type="text" name="math" value="${dto.math}">
		</div>
		<div>
			<label>총점</label>
			 <input type="text" name="total" value="${dto.total}">
		</div>
			<div>
			<label>평균</label>
			 <input type="text" name="avg" value="${dto.avg}">
		</div>

	 <input type="submit" value="등록">
	   <button type="submit">등록</button>
	</form>

</body>
</html>