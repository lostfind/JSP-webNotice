<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<title>게시글 작성</title>
</head>
<body>
	<h3>게시글 작성</h3>

	<form action="insert.do" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
		제목 : <input type="text" name="title" />&nbsp;&nbsp;&nbsp;작성자 : <input type="text" name="user_id" />
		<br/>
		내용 : <textarea rows="10" cols="20" name="content"></textarea>
		<br/>
		첨부파일 : <input type="file" name="filename">
		<br/>
		<input type="submit" />
	</form>
<script>
	function formCheck() {
		var title = document.forms[0].title.value;

		if(title == null || title == "") {
			alert("제목을 입력하세요");
			document.forms[0].title.focus();
			return false;
		}
	}
</script>

</body>
</html>