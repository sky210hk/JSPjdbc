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

@WebServlet("/Modify_ok")
public class Modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Modify_ok() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//현재 세션에 해당하는 회원정보가 필요합니다.
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		//DAO클래스의 getUserInfo메서드를 호출한다.
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getUserInfo(id);
		
		//name, gender, region을 다음페이지에서 1회성으로 사용하기 위해
		if(vo == null) {
			response.sendRedirect("login.jsp");
		} else {
			
			request.setAttribute("user_name", vo.getName());
			request.setAttribute("user_region", vo.getRegion());
			request.setAttribute("user_gender", vo.getGender());
			
			//포워드 이동
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		
		
		/*
		//데이터베이스 연결주소
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "jsp";
		String upw = "jsp";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//conn
			conn = DriverManager.getConnection(url, uid, upw);

			//pstmt
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString("name");
				String region = rs.getString("region");
				String gender = rs.getString("gender");
				
				//1회성 데이터로 사용하기 위해 request에 저장
				request.setAttribute("user_name", name);
				request.setAttribute("user_region", region);
				request.setAttribute("user_gender", gender);
				
				//포워드 이동
				request.getRequestDispatcher("update.jsp").forward(request, response);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {

			}
		}




		 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
