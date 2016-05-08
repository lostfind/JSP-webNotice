<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css"/>
<%
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
		
		out.print("MySQL 접속에 성공함");
		
		stmt = conn.createStatement();
		String sql = "select * from testdb.NOTICE order by idx desc";
		
		rs = stmt.executeQuery(sql);

%>
<title>웹 게시판 만들기 공부</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<a href="write.jsp">
		<button>작성</button>
	</a>
	
	<table border=1>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
		
<%
	while(rs.next()) {
		out.print("<tr>");
		out.print("<td>" + rs.getString("idx") + "</td>");
		out.print("<td> <a href='content.jsp?idx=" + rs.getString("idx") + "'>" + rs.getString("title") + "</a></td>");
		out.print("<td>" + rs.getString(3) + "</td>");
		out.print("<td>" + rs.getString(4) + "</td>");
		out.print("<td>" + rs.getString(6) + "</td>");
		out.print("</tr>");
	}
%>
	</table>
<%
		stmt.close();
		conn.close();
	} catch (Exception e) {
		out.println("MySQL DB connetion Error. <hr>");
		out.println(e.getMessage());
		e.printStackTrace();
	}
%>
</body>
</html>