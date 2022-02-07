<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("user_id");
	String name = (String)session.getAttribute("user_name");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3><%=id %>(<%=name %>)님 환영합니다</h3>
	
	<a href = "logout.jsp">로그아웃</a>
	<a href = "Modify_ok">회원정보수정</a>
	<a href = "Delete_ok">회원탈퇴</a>	
	
	
</body>
</html>