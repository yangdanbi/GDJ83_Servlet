<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>날씨 수정페이지</h2>
	<form action="./update" method="post">
		<div>
		<!--누구를 수정할건지에 대한 num 수정하면 cont로 가서 serv로 보내고
		 dao로 보내고 값이 일치하는애를 찾아서변경하고 파일수정  -->
		 <!-- 삭제는 하나르 ㄹ삭제하고 파일에 넣었는데 수정은 모두 다 넣지만 수정한것만 -->
			<input type="hidden" name="num" value="${dto.num}">
		</div>
		<div>
			<label>도시명</label> 
			<input type="text" name="city" value="${dto.city}">
		</div>
		
		<div>
			<label>기온</label>
			<input type="text" name="gion" value="${dto.gion}">
		</div>
		
		<div>
			<label>습도</label> 
			<input type="text" name="huminity" value="${dto.huminity}"> 
		</div>
		
		<div>
			<label>현재상태</label> 
			<input	type="text" name="status" value = "${dto.status}"> 	 
	   </div>
	 	   
	   <input type="submit" value="등록">
	   <button type="submit">등록</button>
	</form>

</body>
</html>