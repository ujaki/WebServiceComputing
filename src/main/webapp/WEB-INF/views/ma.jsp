<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>기계 앵커</title>
</head>
<body>
네이버 뉴스 검색 API + 음성합성 API<br/>
<form action="/news/machine_anchor" method="GET">
    <input type="text" name="searchWord" placeholder="검색어" required/></br>
    뉴스 개수<select name="num" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select> </br>
    <input type="submit" value="검색">
</form>
</body>
</html>