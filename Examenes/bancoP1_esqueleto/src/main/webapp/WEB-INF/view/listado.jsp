<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 06/05/2024
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List <CuentaEntity> cuentas = (List<CuentaEntity>) request.getAttribute("cuentas");
%>
<html>
<head>
    <title>Cuentas</title>
</head>
<body>
<div>
    <h1>Lista de cuentas de clientes</h1>
    <table border="1">
        <tr style="text-align: center">
            <td><b>NOMBRE</b></td>
            <td><b>NIE</b></td>
            <td><b>IBAN</b></td>
            <td><b>SALDO ACTUAL</b></td>
            <td></td>
            <td></td>
        </tr>
        <%
            for(CuentaEntity cuenta : cuentas)
            {
        %>
        <tr>
            <td><%=cuenta.getClienteByTitular().getNombre()%></td>
            <td><%=cuenta.getClienteByTitular().getNie()%></td>
            <td><%=cuenta.getIban()%></td>
            <td><%=cuenta.getSaldoactual()%></td>
            <td>
                <%
                    if(cuenta.getActiva()==1)
                    {
                %>
                <a href="/desactivar?id=<%=cuenta.getCuentaid()%>">Desactivar</a>
                <%
                    } else
                    {
                %>
                <a href="/activar?id=<%=cuenta.getCuentaid()%>">Activar</a>
                <%
                    }
                %>
            </td>
            <td>
                <a href="/transferencia?id=<%=cuenta.getCuentaid()%>">Realizar Transferencia</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
