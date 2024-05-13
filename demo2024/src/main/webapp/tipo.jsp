<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String gen = (String)session.getAttribute("genero");
%>
<html>
<head>
    <title>Elegir Tipo</title>
</head>
<body>

<script>
    window.onload = function() {
        const selectElement = document.querySelector("select");
        const buttonElement = document.querySelector("#activado");

        selectElement.addEventListener("change", () => {
            const selectedOption = selectElement.value;

            if (selectedOption !== "def") {
                buttonElement.style.display = "block"; // Show button
                document.querySelector("option[value='def']").hidden = true;
            }
        });

        // Ocultar el botón por defecto
        if (selectElement.value === "def") {
            buttonElement.style.display = "none";
        }
    };
</script>

<form method="post" action="/recogerTipo">
    ¿Que prefieres del género ${genero}? <!-- puede utilizarse tmbien <%=gen%> -->
    </br>
    <table>
        <tr>
            <input type="radio" name="tipo" value="series" style="margin-top: 10px">Series
        </tr>
        </br>
        <tr>
            <input type="radio" name="tipo" value="peliculas" style="margin-top: 10px">Peliculas

        </tr>
    </table>
    </br>
    <button>Enviar</button>
    <!--
    <select onchange="document.getElementById('reset-button').dispatchEvent(new Event('change'))" style="margin-top: 10px">
        <option name="tipo" value="def" selected disabled>Selecciona una opción
        <option name="tipo" value="series">Series
        <option name="tipo" value="peliculas">Peliculas
    </select>
    </br>
    <button id="activado" style="margin-top: 10px">Enviar</button>-->
</form>


</body>
</html>