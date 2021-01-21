<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>회원상세조회</title>
</head>
<body>
<h1>회원 정보 상세 조회</h1>
<p>아이디 : ${mvo.user}</p>
<p>이름 : ${mvo.name}</p>
<p>회원등급 : ${mvo.grade}</p>
<p>회원마일리지 : ${mvo.points}</p>
<p>등록일 : ${mvo.regdate}</p>

<button type="button" onclick="modMember('${mvo.user}')">회원 수정</button>
<button type="button" onclick="delMember('${mvo.user}')">회원 삭제</button>

<script>
    function modMember(user){
        location.href='/memberupd?user=' + user;
    }
    function delMember(user){
        location.href='/memberdel?user=' + user;
    }
</script>

</body>
</html>
