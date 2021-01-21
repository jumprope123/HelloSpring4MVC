<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>회원가입하기</title>
</head>
<body>
<h1>회원 가입 하기</h1>
<form name="mbfrm" method="post" action="/memberok">
    <div><label>아이디</label><input type="text" name="user"></div>
    <div><label>비밀번호</label><input type="password" name="passwd"></div>
    <div><label>이름</label><input type="text" name="name"></div>
    <div><button type="submit">입력완료</button>
    <button type="reset">입력취소</button></div>
</form>
</body>
</html>
