<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.07.2021
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="=stylesheet" type="text/css" href="style.css">
</head>
<body>

<h1><%= "СТУДЕНТЫ" %>
</h1>
<br/>
<H1 class=h1>JSTL
</H1>
<p>
    <c:out value="${requestScope.myParam}"/>
    <%= request.getAttribute("myParam")%>
</p>
<select>
    <c:forEach items="${requestScope.paramList}" var="item">
        <option>${item}</option>
    </c:forEach>
</select>
</body>
</html>
