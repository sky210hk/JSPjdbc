<%@page import="com.servlet.MemberVO"%>
<%@page import="com.servlet.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MemberDAO생성하기
	//static이기 때문에 변수명.메서드명으로 간단히 부를 수 있음.
	MemberDAO dao = MemberDAO.getInstance(); 
	MemberVO vo = dao.getUserInfo("abc");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	이름 : <%= vo.getName() %><br>
	성별 : <%= vo.getGender()	%><br>
	지역 : <%= vo.getRegion() %>

</body>
</html>