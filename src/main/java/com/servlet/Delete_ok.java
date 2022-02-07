package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Delete_ok")
public class Delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete_ok() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * SQL문 : delete from member id = ?
		 * 
		 * 1. 아이디는 세션에서 얻습니다.
		 * 2. executeUpdate()문장으로 삭제를 진행합니다.
		 * 3. 삭제 성공 시에는 세션을 전부 삭제하고 login.jsp로 리다이렉트,
		 * 4. 삭제 실패 시에는 login_welcome.jsp로 리다이렉트
		 */
		request.setCharacterEncoding("UTF-8");

		//id를 세션에서 얻는다. 나머지는 request에서 받음
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.delete(id);
		
		if(result == 1)	{
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("login_welcome.jsp");
		}
		
		/*
		//데이터베이스 연결주소
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "jsp";
		String upw = "jsp";

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM MEMBER WHERE ID = ?";

		try {
			//1. 드라이버 호출
			Class.forName("oracle.jdbc.driver.OracldDriver");

			//2. 커넥션 생성
			conn = DriverManager.getConnection(url, uid, upw);

			//3. state 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			int result = pstmt.executeUpdate();

			if(result == 1) {
				session.invalidate();
				response.sendRedirect("login.jsp");
			} else {
				response.sendRedirect("login_welcome.jsp");

			}
		} catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("fail.jsp");
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception e2) {

			}
		}
		 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
