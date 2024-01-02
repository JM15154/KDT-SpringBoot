<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		$("form").on("submit", function() {
			// 사용자 입력
			var result = false;
			if(result) {
				alert("사용자 입력 필수 입니다.");
				event.preventDefault();
			}
		});
		
		$("#btnUpdate").on("click", function() {
			   var f = $("#myForm")[0];
			   f.action="update";
			   f.method="post";
		});
		$("#btnDelete").on("click", function() {
			
			event.preventDefault();
			location.href="delete?num="+${board.num};
			
		});
	});
</script>
</head>
<body>

<h3>글 자세히 보기</h3>
<form id="myForm" action="#" method="post">
<input type="hidden" name="num" value="${board.num}">

	글번호 : ${board.num }&nbsp; &nbsp;
	작성일 : ${board.writeday }&nbsp; &nbsp;
	조회수 : ${board.readcnt}<br>

	제목 <input type="text" name="title" value="${board.title }"> <br>
	작성자 <input type="text" name="author" value="${board.author }"> <br>
	내용 <textarea rows="20" cols="20" name="content">"${board.content }"</textarea> <br>
	<button id="btnUpdate">수정</button>
	<button id="btnDelete">삭제</button>
</form>



<a href="list">뒤로가기</a>
</body>
</html>