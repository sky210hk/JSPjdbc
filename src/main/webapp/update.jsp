<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("user_name");
	String region = (String)request.getAttribute("user_region");
	String gender = (String)request.getAttribute("user_gender");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>회원정보수정</h3>
	
	<form action="Update_ok" method="post">
	
		비밀번호:<input type="password" name="pw" required><br>
		이름:<input type="text" name="name" value = "<%= name %>"><br>
		
		지역:
		<select name="region">
			<option value="서울" <%= region.equals("서울") ? "selected" : "" %>>서울</option>
			<option value="경기도" <%= region.equals("경기도") ? "selected" : "" %>>경기도</option>
			<option value="부산" <%= region.equals("부산") ? "selected" : "" %>>부산</option>
		</select>
		
		<br>
		성별:
		
		<% if(gender == null || gender.equals("m")){ %>
		<input type="radio" name="gender" value="m" checked>남자
		<input type="radio" name="gender" value="w" >여자
		<% } else { %>
		<input type="radio" name="gender" value="m"> 남자
		<input type="radio" name="gender" value="w" checked>여자
		<% } %>		
		
		
		
		<input type="submit" value="가입">
	</form>
	


</body>
</html>