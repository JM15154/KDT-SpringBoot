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
	
	<c:set var="list" value="${pageDTO.list }"></c:set>
	<c:forEach var="dto" items="${list }">
		<tr>
			<th>${dto.num }</th>
			<th><a href="retrieve?num=${dto.num }">${dto.title }</a></th>
			<th>${dto.author }</th>
			<th>${dto.writeday }</th>
			<th>${dto.readcnt }</th>
		</tr>
	</c:forEach>
	
	<c:set var="totalCount" value="${pageDTO.totalCount }"></c:set>
	<c:set var="perPage" value="${pageDTO.perPage }"></c:set>
	<c:set var="curPage" value="${pageDTO.curPage }"></c:set>
	
	<c:set var="totalNum" value="${totalCount/perPage }"></c:set>
	
	<c:if test="${totalCount%perPage !=0 }">
	<c:set var="totalNum" value="${totalNum + 1 }"></c:set>
	
	</c:if>
	
	
	<tr>
		<td colspan="5">
			<c:forEach var="i" begin="1" end="${totalNum }">
				
				<c:if test="${curPage == i }">
					${i } &nbsp;
				
				</c:if>
				
				<c:if test="${curPage != i }">
				
				<a href="list?curPage=${i }">${i }</a>
				</c:if>
			</c:forEach>
		</td>
	</tr>
</table>

<a href="write">글쓰기</a>
</body>
</html>