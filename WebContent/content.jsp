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
	
	String idx = request.getParameter("idx");

	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(URL, USER, PASS);
		
		out.print("MySQL 접속에 성공함");
		
		stmt = conn.createStatement();
		String sql = "select * from testdb.NOTICE where idx = " + idx;
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {

%>
<title>웹 게시판 만들기 공부</title>
</head>
<body>
	<h1>게시글 조회</h1>
	
	<table border=1>
		<tr>
			<th>번호</th>
			<td><%=rs.getString("idx") %></td>
			<th>작성자</th>
			<td><%=rs.getString("user_id") %></td>
			<th>작성일시</th>
			<td><%=rs.getString("reg_dttm") %></td>
			<th>조회수</th>
			<td><%=rs.getString("count") %></td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="6"><%=rs.getString("title") %></td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
			<td colspan="6"><%=rs.getString("content") %></td>
		</tr>
	</table>
	<a href="delete.jsp?idx=<%=rs.getString("idx")%>">게시글삭제</a>
	<a href="index.jsp">목록으로</a>
<%
		}
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