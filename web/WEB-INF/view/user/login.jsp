<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ㄹ그인</title>
</head>
<body>

    <h1>로그인</h1>
    <div>${requestScope.msg}</div>
    <div>
        <form action="/user/login" method="post">
            <div><input type="text" name="uid" placeholder="id"></div>
            <div><input type="password" name="upw" placeholder="password"></div>
            <div><input type="submit" placeholder="Login"></div>
        </form>
    </div>
    <div>
        <a href="/user/join">JOIN!</a>
    </div>
</body>
</html>