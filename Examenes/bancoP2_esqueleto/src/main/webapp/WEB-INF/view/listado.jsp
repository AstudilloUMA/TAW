<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.sampletaw.entity.CuentaEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.sampletaw.entity.MovimientoEntity" %>
<%@ page import="es.taw.sampletaw.ui.Filtro" %>
<%@ page import="es.taw.sampletaw.entity.TipocomisionEntity" %><%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 10/05/2024
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<CuentaEntity> cuentas = (List<CuentaEntity>) request.getAttribute("cuentas");
    List<TipocomisionEntity> tipos = (List<TipocomisionEntity>) request.getAttribute("tipos");
    Filtro filtro = (Filtro) request.getAttribute("filtro");
%>
<html>
<head>
    <title>Listado</title>
</head>
<body>
<h1>Cuentas:</h1>
<div>
    <table border="1">
        <tr>
            <form:form action="/filtrar" modelAttribute="filtro" method="post">
                <td>
                    <form:select path="tipoComision">
                        <%
                            for(TipocomisionEntity comision : tipos)
                            {
                                if(comision.getValor() == 0){
                        %>
                                    <form:option value="<%=comision%>">Sin comisión</form:option>
                        <%
                                }else{
                        %>
                                    <form:option value="<%=comision%>"><%=comision.getValor()*100%>%</form:option>
                        <%
                                }
                            }
                        %>
                    </form:select>
                </td>
                <td>
                    Saldo > <form:input path="saldoMin"/>
                </td>
                <td>
                    <button>Filtrar</button>
                </td>
            </form:form>
        </tr>
    </table>
    <a href="/"><button>Sin filtros</button></a>
</div>
<div>
    <table border="1">
        <tr style="text-align: center">
            <td><b>IBAN</b></td>
            <td><b>SALDO ACTUAL</b></td>
            <td><b>MOVIMIENTOS</b></td>
            <td><b>COMISIÓN APLICADA</b></td>
        </tr>
        <%
            for(CuentaEntity c : cuentas)
            {
        %>
                <tr>
                    <td>
                        <a href="/mostrar?id=<%=c.getCuentaid()%>"><%=c.getIban()%></a>
                    </td>
                    <td><%=c.getSaldoactual()%></td>
                    <td>
                        <table>
                            <%
                                if (!c.getMovimientosByCuentaid().isEmpty())
                                {
                                    for(MovimientoEntity m : c.getMovimientosByCuentaid())
                                    {

                            %>
                                        <tr><td><%=m.toString()%></td></tr>
                            <%
                                    }
                                } else {

                            %>
                                        <tr><td>Sin movimientos</td></tr>
                            <%
                                }
                            %>
                        </table>
                    </td>
                    <td>
                        <%
                            if(c.getTipocomisionByComision().getValor().equals(0.0))
                            {
                        %>
                                Sin comisión
                        <%
                            } else {
                        %>
                                <%=c.getTipocomisionByComision().getValor()*100%>%
                        <%
                            }
                        %>
                    </td>
                </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
