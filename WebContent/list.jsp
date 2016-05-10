<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css"/>
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
		
		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>${article.idx}</td>
				<td><a href="content.jsp?idx=${article.idx}">${article.title}</a></td>
				<td>${article.userid }</td>
				<td>${article.regdttm}</td>
				<td>${article.count}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>