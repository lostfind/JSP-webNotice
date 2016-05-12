<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MySQL Connect Test</title>
</head>
<body>
<%
String URL = "jdbc:mysql://localhost:3307/testdb";
String USER = "dwkim";
String PASS = "dwkim";
String query = "select user_nm from USER;";

Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(URL, USER, PASS);
	stmt = conn.createStatement();
	
	rs = stmt.executeQuery(query);
	out.print("DB Connect Result : ");
	
	String s;
	while(rs.next()) 
	{
		out.print(rs.getString(1));
		out.println(" ");
	}
	rs.close();
	stmt.close();
	conn.close();
	
} catch(SQLException e) {
	out.print(e.getMessage());
} finally {
	
}
%>
</body>
</html>