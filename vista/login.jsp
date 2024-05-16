<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vista/css/registro.css">
        <title>Iniciar Sesión</title>
    </head>
    <body>
    <center>
        <h2>Iniciar Sesión</h2>
        <c:if test="${Error != null}">
            <p style="color:red;">${Error}</p>
        </c:if>
        <form action="/proyecto_LucasSocrates_DominguezAgudo/caja" method="post">
            <div>
                <label for="correoLogin">Correo Electronico:</label>
                <input type="text" id="correoLogin" name="correoLogin" required>
            </div>
            <div>
                <label for="passwordLogin">Contraseña:</label>
                <input type="password" id="passwordLogin" name="passwordLogin" required>
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
        <p>¿No tienes una cuenta? <a href="/proyecto_LucasSocrates_DominguezAgudo/registro">Regístrate</a></p>
    </center>
</body>
</html>
