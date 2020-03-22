<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>

	<label>제목</label> ${view.title}
	<br />
	<!-- value 로 넘겨주는 모델 이름 설정 -->

	<label>작성자</label> ${view.writer}
	<br />

	<label>내용</label>
	<br /> ${view.content}
	<br />
	
	<div>
	<a href="/board/modify?bno=${view.bno}">게시물 수정</a>
	</div>
	
	<div>
	<a href="/board/delete?bno=${view.bno}">게시물 삭제</a>
	</div>

</body>
</html>