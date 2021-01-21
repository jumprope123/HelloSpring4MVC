<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 수정</title>
</head>
<body>
<h1>회원 수정</h1>
<form name="mbfrm" method="post" action="/memberupdok">
    <div><label>아이디</label><input type="text" name="user" value="${mvo.user}" readonly></div>
    <div><label>비밀번호</label><input type="password" name="passwd" value="${mvo.passwd}"></div>
    <div><label>이름</label><input type="text" name="name" value="${mvo.name}"></div>
    <div><label>등급</label><input type="text" name="grade" value="${mvo.grade}"></div>
    <div><label>포인트</label><input type="text" name="points" value="${mvo.points}"></div>
    <div><button type="submit">입력완료</button>
        <button type="reset" onclick="redirect()">입력취소</button></div>
</form>
<script>
    function redirect() {
        location.href='/memberlist'
    }
</script>
</body>
</html>
