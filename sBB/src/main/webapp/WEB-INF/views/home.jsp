<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<meta charset="UTF-8">
<body>
<ul>
	<li>
		<a href="/board/listPage?num=1">글 목록(페이징)</a>
	</li>
	
	<li>
		<a href="/board/list">게시물 목록</a>
	</li>
	
	<li>
		<a href="/board/write">게시물 작성</a>
	</li>
	
</ul>

</body>
</html>
