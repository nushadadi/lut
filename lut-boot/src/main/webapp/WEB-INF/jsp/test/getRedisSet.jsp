<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZCM
  Date: 2019-07-20
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:forEach items="${set}" var="r">
        ${r}

    </c:forEach>
    <a href="http://localhost:8080/lut/test/toAddTestPage">Add</a>
</head>
<body>

</body>
</html>
