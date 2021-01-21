<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>전체 회원 조회</title>
</head>
<body>
<h1>전체 회원 조회</h1>
<table width="350" border="1" cellspacing="0" cellpadding="10">
    <tr><th>아이디</th><th>회원등급</th><th>가입일</th></tr>
    <c:forEach var="m" items="${mvos}">
    <tr><td><a href="/memberview?user=${m.user}">${m.user}</a></td><td>${m.grade}</td><td>${fn:substring(m.regdate,0,10)}</td></tr>
    </c:forEach>
</table>
</body>
</html>
