<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vista/css/registro.css">
        <title>Registro</title>
    </head>
    <body>
    <center>
        <h2>Registro</h2>
        <c:if test="${Error != null}">
            <p style="color:red;">${Error}</p>
        </c:if>
        <form action="/proyecto_LucasSocrates_DominguezAgudo/caja" method="post">
            <div>
                <label for="correoReg">Correo electrónico:</label>
                <input type="email" id="correoReg" name="correoReg" required>
            </div>
            <div>
                <label for="passwordReg">Contraseña:</label>
                <input type="password" id="passwordReg" name="passwordReg" required>
            </div>
            <div>
                <label for="tarjeta_credito">Número de tarjeta de crédito:</label>
                <input type="text" id="tarjeta_credito" name="tarjeta_credito" pattern="[0-9]{16}" required>
            </div>
            <div>
                <label for="tipo_tarjeta">Tipo de tarjeta:</label>
                <select id="tipo_tarjeta" name="tipo_tarjeta" required>
                    <option value="Visa">Visa</option>
                    <option value="MasterCard">MasterCard</option>
                    <option value="American Express">American Express</option>
                    <!-- Agregar otras opciones según sea necesario -->
                </select>
            </div>
            <button type="submit">Registrarse</button>
        </form>
        <p>¿Ya tienes una cuenta? <a href="/proyecto_LucasSocrates_DominguezAgudo/login">Inicia sesión</a></p>

    </center>

</body>
</html>
