<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elegir Genero</title>
</head>
<body>
<form method="post" action="/procesarGenero">
    ¿Que g&eacutenero es tu favorito?
    </br>
    <input type="radio" name="genero" value="terror" style="margin-top: 10px">Terror
    </br>
    <input type="radio" name="genero" value="ciencia ficci&oacuten" style="margin-top: 10px">Ciencia ficci&oacuten
    </br>
    <input type="radio" name="genero" value="comedia" style="margin-top: 10px">Comedia
    </br>
    <button style="margin-top: 10px">Enviar</button>

</form>
</body>
</html>