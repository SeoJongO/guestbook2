<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int guestNo = (int)request.getAttribute("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form</title>
</head>
<body>

	<h1>방명록 삭제폼</h1>
	<form action="/guestbook2/gc" method="post">
		<input type="hidden" name="action" value="delete">
		<input type="hidden" name="no" value="<%=guestNo%>">
		비밀번호 <input type="text" name="password" value="">
		<button type="submit">확인</button><br>
		<a href="/guestbook2/gc?action=list">메인으로 돌아가기</a>
	</form>

</body>
</html>
