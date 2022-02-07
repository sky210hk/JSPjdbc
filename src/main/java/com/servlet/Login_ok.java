package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login_ok")
public class Login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//2. MemberVO가 null값이라면 로그인 실패 -> login_fail.jsp로 이동
		//3. MemberVO가 값을 가지고 있다면 -> login_welcome.jsp로 이동
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.login(id, pw);
		
		if(vo == null) { //아이디, 비밀번호 틀린 경우
			response.sendRedirect("login_fail.jsp");
		} else { //로그인에 성공한 경우
			
			//세션에 값을 저장함
			HttpSession session = request.getSession();
			session.setAttribute("user_id", vo.getId());
			session.setAttribute("user_name", vo.getName());
			
			response.sendRedirect("login_welcome.jsp");
		}
		
		/*
		//데이터베이스 연결주소
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "jsp";
		String upw = "jsp";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ?";
		
		try {
			//1.드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. conn
			conn = DriverManager.getConnection(url, uid, upw);
			
			//3. pstmt
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //아이디 비밀번호가 맞은경우
				
				String name = rs.getString("name"); //name컬럼을 꺼낸다
				
				//request에서 세션을 얻는다.
				HttpSession session = request.getSession();
				session.setAttribute("user_id", id);
				session.setAttribute("user_name", name);
				
				//성공페이지로
				response.sendRedirect("login_welcome.jsp");
				
			} else { //아이디 비밀번호가 틀린경우
				response.sendRedirect("login_fail.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
 				// TODO: handle exception
			}
		}
		*/
		
		
		
		
		
		
		
		
		
		
	}

}
