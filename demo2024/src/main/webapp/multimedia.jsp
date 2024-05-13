<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String tipo = (String)session.getAttribute("tipo");
    String genero = (String) session.getAttribute("genero");
    List<String> opciones = (List<String>) request.getAttribute("opciones");
%>
<html>
<head>
    <title>Opciones multimedia</title>
</head>
<body>
Selecciona tus <%=tipo%> preferidas de <%=genero%>:
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