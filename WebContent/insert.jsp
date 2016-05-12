<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice insert</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String user_id = request.getParameter("user_id");
	String content = request.getParameter("content");
	
	String URL = "jdbc:mysql://localhost:3307/testdb";
	String USER = "dwkim";
	String PASS = "dwkim";
	String query = "INSERT INTO testdb.NOTICE"
					+ "(TITLE, USER_ID, CONTENT, REG_DTTM) " 
					+ "VALUES ('" + title + "', '" + user_id + "', '" + content + "', sysdate());";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USER, PASS);
		stmt = conn.createStatement();
		
		out.print("MySQL 접속에 성공함");
		out.print("<br/>");
		out.print(query);
		
		stmt.executeUpdate(query);
		
		stmt.close();
		conn.close();
		
		
	} catch(SQLException e) {
		out.println("MySQL 접속에 문제가 있음<hr>");
		out.print(e.getMessage());
		e.printStackTrace();
	} finally {
		out.print("<script>location.href='list.do';</script>");
		
	}
%>
</body>
</html>