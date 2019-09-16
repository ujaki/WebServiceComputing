<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title></title>
</head>
<body>
네이버 음성합성 TEST<br/>
<form action="/vsplayer" method="POST">
    <input type="text" name="vsplay" value="반갑습니다."/>
    <input type="submit" value="재생">
</form>


</body>
</html>
