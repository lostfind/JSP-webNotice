<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
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
				<td><a href="count.do?idx=${article.idx}">${article.title}</a></td>
				<td>${article.user_id }</td>
				<td>${article.reg_dttm}</td>
				<td>${article.count}</td>
			</tr>
		</c:forEach>

	</table>

	<c:if test="${page > 0}">
		<a href="list.do?page=${page-1}">이전페이지</a>
	</c:if>
	<c:if test="${page == 0}">
		<a href="#">이전페이지</a>
	</c:if>

	&nbsp;
	<c:forEach begin="1" varStatus="i" end="${pageTotal}">
		<c:if test="${page+1 == i.count}">
			<b>
				<a href="list.do?page=${i.index-1}">[${i.index}/${pageTotal}]</a>
			</b>
		</c:if>
		<c:if test="${page+1 != i.count}">
			<a href="list.do?page=${i.index-1}">[${i.index}/${pageTotal}]</a>
		</c:if>
	</c:forEach>
	&nbsp;

	<c:if test="${page+1 == pageTotal}">
		<a href="#">다음페이지</a>
	</c:if>
	<c:if test="${page+1 != pageTotal}">
		<a href="list.do?page=${page+1}">다음페이지</a>
	</c:if>
</body>
</html>