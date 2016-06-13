<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function onDownload(idx) {
		var o = document.getElementById("ifrm_filedown");
		o.src = "download.do?idx="+idx;
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>웹 게시판 만들기 공부</title>
</head>

<body>
	<h1>게시글 조회</h1>
	<table border=1>
		<tr>
			<th>번호</th>
			<td>${article.idx}</td>
			<th>작성자</th>
			<td>${article.user_id}</td>
			<th>IP</th>
			<td>${article.regip}</td>
			<th>작성일시</th>
			<td>${article.reg_dttm}</td>
			<th>조회수</th>
			<td>${article.count}</td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="8">${article.title}</td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
			<td colspan="8">${article.content}</td>
		</tr>
		<tr>
			<th colspan="2">첨부파일</th>
			<td colspan="8"><a href="#" onclick="onDownload(${article.idx})">${article.filename}</a></td>
		</tr>
	</table>
	<a href="delete.do?idx=${article.idx}">게시글삭제</a>
	<a href="#" onclick="closeContent()">목록으로</a>

	<iframe id="ifrm_filedown" style="position:absolute; z-index:1; visibility : hidden;">
	</iframe>

</body>
</html>