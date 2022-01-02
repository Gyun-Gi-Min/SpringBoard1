<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입~</h1>
    <div>${requestScope.msg}</div>
    <div>
    <form action="/user/join" method="post" >
        <div><input type="uid" name="uid" placeholder="아이디입력"> </div>
        <div><input type="password" name="upw" placeholder="비밀번호 입력"> </div>
        <div><input type="text" name="nm" name="이름" placeholder="이름입력"> </div>
        <div>
            <label>female<input type="radio" value="2" name="gender" checked></label>
            <label>male<input type="radio" value="1" name="gender"></label>
        </div>
        <div>
            <input type="submit" value="join">
        </div>
    </form>
    </div>
    <div>
        <a href="/user/join">Join</a>
    </div>
</body>
</html>