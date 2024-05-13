<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="es.taw.sampletaw.entity.ClienteEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 06/05/2024
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CuentaEntity cuenta = (CuentaEntity) request.getAttribute("cuenta");
    List <CuentaEntity> cuentas = (List<CuentaEntity>) request.getAttribute("cuentas");
    ClienteEntity cliente = cuenta.getClienteByTitular();
%>
<html>
<head>
    <title>Transferencia</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <td>Nombre: <%=cliente.getApellidos()%>, <%=cliente.getNombre()%></td>
            <td>NIE: <%=cliente.getNie()%></td>
            <td>Telefono: <%=cliente.getTelefono()%></td>
            <td>Cuente: <%=cuenta.getIban()%></td>
        </tr>
    </table>
</div>

<h1>Realizar transferencias entre cuentas:</h1>

<div>
    <form action="/realizar" method="post">
        <input name="origen" value="<%=cuenta.getCuentaid()%>" type="hidden"></input>
        <table>
            <tr>
                <td>Destinatario:
                    <select name="destino">
                        <%
                            for (CuentaEntity c : cuentas)
                            {
                                if (!c.equals(cuenta))
                                {
                        %>
                        <option value="<%=c.getCuentaid()%>"><%=c.getIban()%></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    Descripcion: <input name="descripcion" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    Cantidad: <input name="cantidad" type="number">
                </td>
            </tr>
        </table>

        <button>Realizar</button>
    </form>
</div>
</body>
</html>
