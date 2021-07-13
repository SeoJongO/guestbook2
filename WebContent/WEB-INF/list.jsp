<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.GuestBookVo"%>
<%
List<GuestBookVo> guestList = (List<GuestBookVo>) request.getAttribute("gList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone Book</title>
</head>
<body>

	<form action="/guestbook2/gc" method="post">
		<input type="hidden" name="action" value="insert">
		<table border="1">
			<tr>
				<td>이름 <input type="text" name="name" value=""></td>
				<td>비밀번호 <input type="text" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="content" rows=10px cols=70px></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">확인</button></td>
			</tr>
		</table>
	<br>
	</form>

	<% for (int i = 0; i < guestList.size(); i++) { %>
		<table border="1">
			<tr>
				<td><%=guestList.get(i).getNo()%></td>
				<td><%=guestList.get(i).getName()%></td>
				<td><%=guestList.get(i).getReg_date()%></td>
				<td><a href="/guestbook2/gc?action=dForm&no=<%=guestList.get(i).getNo()%>">[삭제]</a></td>
			</tr>
			<tr>
				<td colspan="4"><pre><%=guestList.get(i).getContent()%></pre></td>
			</tr>
		</table>
	<br>
	<% } %>

</body>
</html>
