<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<HTML>
    <HEAD>
        <TITLE>Caja</TITLE>
        <meta charset="UTF-8">
    </HEAD>
    <BODY>
    <center>
        <H1>Caja</H1>
        <H2>Total a pagar</H2>
        <p><%= session.getAttribute("precioFinal") %></p>
        <a href="/minitienda/caja"><button type="button">Pagar</button></a>
    </center>
</BODY>
</HTML>
