<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.06.2021
  Time: 20:16
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

<h1><%= "New project" %>
</h1>
<br/>
<H1 class=h1>JSTL
</H1>
<c:out value="${requestScope.myParam}"/>
<%= request.getAttribute("myParam")%>
</body>
</html>
