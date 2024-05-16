<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<HTML>
    <HEAD>
        <TITLE>Caja</TITLE>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vista/css/registro.css">
    </HEAD>
    <BODY>
    <center>
        <H1>Caja</H1>
        <H2>Total a pagar</H2>
        <p>Bienvenido ${user.correo} el precio a pagar es de: ${precioFinal}$</p>
        <a href="/proyecto_LucasSocrates_DominguezAgudo/index.html"><button type="button">Seguir Comprando</button></a>
        <a href="/proyecto_LucasSocrates_DominguezAgudo/pagar"><button type="button">Pagar</button></a>
    </center>
</BODY>
</HTML>
