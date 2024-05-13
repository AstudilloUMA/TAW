<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<String> opciones = (List<String>) request.getAttribute("opciones");
    String tipo = (String)session.getAttribute("tipo");
    String genero = (String)session.getAttribute("genero");
%>
<html>
<head>
    <title>Opciones Multimedia</title>
</head>
<body>
<h1>Tus ${tipo} preferidas:</h1>
<form action="/procesarOpciones" method="post">
    <%
        for (String titulo : opciones)
        {

    %>
    </br>
    <input type="checkbox" name="titulos" value="<%=titulo%>"><%=titulo%></input>

    <%
        }
    %>
    <button>Enviar</button>
</form>
</body>
</html>
