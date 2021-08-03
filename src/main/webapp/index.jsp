<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World new</title>
</head>
<meta charset="utf-8">
<title>Green</title>
<style>
    body {
        background: darkseagreen; /* Цвет фона */
        color: #999999; /* Цвет текста */
    }
</style>
<body>
<h1><%= "New project" %>
</h1>
<br/>
<p style="text-align: right"><button>Редактировать</button>
<a href="hello-servlet">Hello Servlet</a>
<%--<a href="student-servlet">student</a>--%>
<%--<a href="teacher-servlet">teacher</a>--%>
<a href="getStudent-servlet">Список студентов</a>
<%--<a href="hello-servlet">hello</a>--%>
<%--<a href="hello-servlet">hello</a>--%>
</body>
</html>