<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.MovimientoEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 06/05/2024
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List <MovimientoEntity> movimientos = (List<MovimientoEntity>) request.getAttribute("movimientos");
%>
<html>
<head>
    <title>Cuenta</title>
</head>
<body>
<div>
    <h1>Lista de movimientos de clientes</h1>
    <table border="1">
        <tr style="text-align: center">
            <td><b>CUENTA ORIGEN</b></td>
            <td><b>CUENTA DESTINO</b></td>
            <td><b>DESCRIPCIÓN</b></td>
            <td><b>CANTIDAD</b></td>
            <td><b>FECHA</b></td>
        </tr>
        <%
            for(MovimientoEntity m : movimientos)
            {
        %>
        <tr>
            <td><%=m.getCuentaByCuentaorigen().getClienteByTitular().getNombre()%>, <%=m.getCuentaByCuentaorigen().getClienteByTitular().getApellidos()%></td>
            <td><%=m.getCuentaByCuentadestinatario().getClienteByTitular().getNombre()%>, <%=m.getCuentaByCuentadestinatario().getClienteByTitular().getApellidos()%></td>
            <td><%=m.getDescripcion()%></td>
            <td><%=m.getCantidad()%></td>
            <td><%=m.getFecha()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="/" style="margin-top: 20px"><button>Inicio</button></a>
</div>
</body>
</html>
