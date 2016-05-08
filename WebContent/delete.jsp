<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<%
	request.setCharacterEncoding("UTF-8");

	String driverName = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3307/testdb";
	String USER = "dwkim";
	String PASS = "dwkim";

	Connection conn = null;
	Statement stmt = null;

	String idx = request.getParameter("idx");

	try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(URL, USER, PASS);

		out.println("MySQL 접속에 성공함\n");

		stmt = conn.createStatement();
		String sql = "delete from testdb.NOTICE where idx = " + idx ;

		out.println("QUERY : " + sql + " \n");

		stmt.executeUpdate(sql);

		stmt.close();
		conn.close();
		
	} catch (Exception e) {
		out.println("MySQL DB connetion Error. <hr>");
		out.println(e.getMessage());
		e.printStackTrace();
	}
%>
<title>웹 게시판 만들기 공부 - 게시글 삭제</title>
</head>

	<script>
		alert("게시글이 삭제되었습니다"); // 게시글이 삭제되었다는 경고창을 띄워주고
		
		location.href = "redirect.jsp"; // 리스트페이지로 이동합니다.
	</script>

<body>
</body>
</html>