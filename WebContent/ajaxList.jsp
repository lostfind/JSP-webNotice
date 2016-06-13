<%--
  Created by IntelliJ IDEA.
  User: DWKIM
  Date: 2016. 6. 13.
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${articleList}" var="article">
	<tr>
		<td><a href="#layer" onclick="openContent('${article.idx}')">${article.idx}</a></td>
		<td><a href="#layer" onclick="openContent('${article.idx}')">${article.title}</a></td>
		<td>${article.user_id }</td>
		<td>${article.reg_dttm}</td>
		<td>${article.count}</td>
	</tr>
</c:forEach>