<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�л� ����������</h2>
	<form action="./update" method="post">
		<div>
			<input type="hidden" name="num" value="${dto.num}">
		</div>
		<div>
			<label>�̸�</label>
			 <input type="text" name="name" value="${dto.name}">
		</div>
		<div>
			<label>��������</label>
			 <input type="text" name="kor" value="${dto.kor}">
		</div>
		<div>
			<label>��������</label>
			 <input type="text" name="eng" value="${dto.eng}">
		</div>
		<div>
			<label>��������</label> 
			<input type="text" name="math" value="${dto.math}">
		</div>
		<div>
			<label>����</label>
			 <input type="text" name="total" value="${dto.total}">
		</div>
			<div>
			<label>���</label>
			 <input type="text" name="avg" value="${dto.avg}">
		</div>

	 <input type="submit" value="���">
	   <button type="submit">���</button>
	</form>

</body>
</html>