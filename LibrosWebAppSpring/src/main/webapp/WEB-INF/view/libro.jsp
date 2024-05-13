<%@ page import="libroswebapp.entity.LibroEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 03/04/2024
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    LibroEntity libro = (LibroEntity) request.getAttribute("libro");
%>
<html>
<head>
    <title>Datos del Libro</title>
</head>
<body>
<h1>Datos del Libro</h1>
<form method="post" action="/guardar">
<input type="hidden" name="id" value="<%= libro.getLibroid()%>"/>
Titulo: <input type="text" size="50" maxlength="100" value="<%= libro.getLibroname()%>" name="titulo"/><br/>
    Año de publicación: <input type="number" size="6" maxlength="4" value="<%= libro.getYearreleased()%>" name="anyo"/><br/>
    <button>Enviar</button>
</form>
</body>
</html>
