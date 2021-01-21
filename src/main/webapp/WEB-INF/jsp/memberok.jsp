<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>회원가입 결과창</title>
</head>
<body>
<h1>회원가입 결과창</h1>
<h3>${result}</h3>
<hr>
<p>아이디 : ${mvo.user}</p>
<p>이름 : ${mvo.name}</p>
<p>회원등급 : 브론즈</p>
<p>회원마일리지 : 1000</p>
</body>
</html>
