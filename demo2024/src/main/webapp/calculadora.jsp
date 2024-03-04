<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>INTRODUZCA LOS OPERANDOS Y OPERACI&OacuteN: </h1>
<form method="post" action="/calcular">
    Operando 1: <input type="number" name="op1" value="${res}"> <br/>
    Operando 2: <input type="number" name="op2"> <br/>
    Operador:
    <input type="radio" name="op" value="+">+
    <input type="radio" name="op" value="-">-
    <input type="radio" name="op" value="*">*
    <input type="radio" name="op" value="/">/
    </br>
    <button>Calcular</button>

</form>

<h1>EL RESULTADO ES</h1>
${op1} ${op} ${op2} = ${res}
</body>
</html>