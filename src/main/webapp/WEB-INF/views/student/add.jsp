<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 한명 정보</title>

</head>
<body>
	<h1>학생정보입력 페이지</h1>
	<!--action="" : 요청할 url  -->
	<form action="/student/add" method="post">
		<div>
			<!-- input 제목 -->
			<!--파라미터이름은 sertter의 이름과 동일하게 맞춰주는게 좋음  -->
			<label for="num">번호</label> 
			<input type="text" id="num" name ="num" value="">
		</div>
		<div>
			<label for="name">이름</label> 
			<input type="text" id="name" name ="name">
		</div>
		<div>
			<label for="avg">평균</label> 
			<input type="text" id="avg" name="avg">
		</div>
		
		<div>
			<label></label>
			<input type="radio" name="ch" value="여성">
			<input type="radio" name="ch" value="남성">
		</div>
		<div>
			<select name = "mobile">
				<option value ="KT">KT</option>
				<option value ="SK">SK</option>
				<option value ="LG">LG</option>
				
			</select>
			<div>
				<input type="checkbox" name = "ch2" value="v1">
				<input type="checkbox" name = "ch2" value="v2">
				<input type="checkbox" name = "ch2" value="v3">
			</div>
			<textarea rows="" cols="" name = "contents"></textarea><!-- 용량이 크거나 보안이 요구되면 post -->
		</div>
		<div>
			<input type="submit" value="등록"> 
			<button type="submit">작성</button>
		</div>

	</form>


</body>
</html>