<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹 게시판 만들기 공부</title>
</head>
<c:if test="${url == null}">
	<script>
		location.href="list.do";
	</script>
</c:if>

<c:if test="${url != null}">
	<script>
		$.ajax({
			type:'post',
			url:'${url}',
			success:function(data) {
				$('#content').html(data);
			}
		});
	</script>

	<div id="content">
	</div>

</c:if>
</html>