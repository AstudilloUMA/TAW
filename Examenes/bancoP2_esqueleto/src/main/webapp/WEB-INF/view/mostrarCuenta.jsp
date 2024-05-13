<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.CuentaclienteEntity" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 10/05/2024
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CuentaEntity c = (CuentaEntity) request.getAttribute("cuenta");
    List<CuentaclienteEntity> cc = (List<CuentaclienteEntity>) request.getAttribute("cuentasClientes");
%>
<html>
<head>
    <title><%=c.getIban()%></title>
</head>
<body>
<h1>Datos de la cuenta corriente:</h1>
<div>
    <table border="1">
        <tr>
            <td>IBAN:</td>
            <td><%=c.getIban()%></td>
        </tr>
        <tr>
            <td>FECHA DE CREACIÓN:</td>
            <td><%=c.getFechacreacion()%></td>
        </tr>
        <tr>
            <td>CLIENTES:</td>
            <td>
                <table>
                    <%
                        for (CuentaclienteEntity aux : cc)
                        {
                            if(aux.getRolclienteByRolid()!=null)
                            {
                            ClienteEntity cliente = aux.getClienteByClienteid();
                    %>
                            <tr>
                                <td>
                                    <%=cliente.getNie()%> - <%=cliente.getNombrecompleto()%>
                                    (<a href="/rol?id=<%=aux.getCuentaclienteid()%>"><%=aux.getRolclienteByRolid().getDescripcion()%></a>)
                                    <a href="/eliminar?id=<%=aux.getCuentaclienteid()%>">X</a>
                                </td>
                            </tr>
                    <%
                            }
                        }
                    %>
                </table>
            </td>
        </tr>
    </table>
</div>
<a href="/">Volver al listado</a>
</body>
</html>
