<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	create table member(
    id varchar2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(30),
    region varchar2(30),
    gender char(1) check(gender in ('m', 'w'))
	);
	--%>
	
	<form action="Join_ok" method="post">
	

		비밀번호:<input type="password" name="pw" required><br>
		이름:<input type="text" name="name" ><br>
		
		지역:
		<select name="region">
			<option value="서울">서울</option>
			<option value="경기도">경기도</option>
			<option value="부산">부산</option>
		</select>
		
		<br>
		성별:
		<input type="radio" name="gender" value="m">남자
		<input type="radio" name="gender" value="w">여자
		
		<input type="submit" value="가입">
	</form>
	



</body>
</html>