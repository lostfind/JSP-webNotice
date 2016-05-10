package com.board.action;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.board.beans.Board;
import com.board.controller.CommandAction;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");

		String driverName = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3307/testdb";
		String USER = "dwkim";
		String PASS = "dwkim";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(URL, USER, PASS);
			
			System.out.println("LIST.DO >>>> MySQL 접속에 성공함");
			
			stmt = conn.createStatement();
			String sql = "select * from testdb.NOTICE order by idx desc";
			
			rs = stmt.executeQuery(sql);
			
			ArrayList<Board> articleList = new ArrayList<Board>();
			
			while(rs.next()) {
				Board article = new Board();
				article.setIdx(rs.getInt("idx"));
				article.setTitle(rs.getString("title"));
				article.setUserid(rs.getString("user_id"));
				article.setRegdttm(rs.getString("reg_dttm"));
				article.setCount(rs.getInt("count"));

				articleList.add(article);
			}
			
			request.setAttribute("articleList", articleList); // 뷰에 리스트 포워드
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.err.println("MySQL DB connetion Error. <hr>");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return "list.jsp";
	}

}
