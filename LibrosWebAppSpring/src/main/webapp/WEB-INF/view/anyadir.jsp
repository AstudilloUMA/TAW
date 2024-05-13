<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 03/04/2024
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Añadir un libro</title>
</head>
<body>

<h1>Añadir un nuevo libro</h1>
<form method="post" action="/nuevo">

    Titulo: <input type="text" maxlength="255" size="50" name="titulo"/><br/><br/>
    Año de Salida: <input type="number" maxlength="4" size="6" name="anyo"/><br/><br/>
    Genero: <input type="text" maxlength="50" size="20" name="genero"/><br/><br/>
    Autor: <input type="text" maxlength="50" size="20" name="autor"/><br/><br/>
    Editorial: <input type="text" maxlength="50" size="20" name="editorial"/><br/><br/>

    <button>Añadir</button>

</form>
</body>
</html>
