<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>게시판 목록</h3>
<table border="1">

	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	
	<c:forEach var="dto" items="${list }">
		<tr>
			<th>${dto.num }</th>
			<th><a href="retrieve?num=${dto.num }">${dto.title }</a></th>
			<th>${dto.author }</th>
			<th>${dto.writeday }</th>
			<th>${dto.readcnt }</th>
		</tr>
	</c:forEach>
</table>

<a href="write">글쓰기</a>
</body>
</html>