<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>날씨 추가</h2>
	<form action="./add" method="post">
		<div>
			<label>도시명</label> 
			<input type="text" name="city">
		</div>
		
		<div>
			<label>기온</label>
			<input type="text" name="gion">
		</div>
		
		<div>
			<label>습도</label> 
			<input type="text" name="huminity"> 
		</div>
		
		<div>
			<label>현재상태</label> 
			<input	type="text" name="status"> 	 
	   </div>
	   
	   <input type="submit" value="등록">
	   <button type="submit">등록</button>
	</form>
</body>
</html>