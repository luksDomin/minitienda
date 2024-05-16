<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE HTML>
<HTML>
    <HEAD>
        <TITLE>Carrito</TITLE>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vista/css/carrito.css">
    </HEAD>
    <BODY>
        <!-- Botones para iniciar y cerrar sesi�n -->
        <form action="/proyecto_LucasSocrates_DominguezAgudo/login" method="get">
            <input type="submit" name="iniciar" value="Iniciar Sesi�n">
            <input type="submit" name="cerrar" value="Cerrar Sesi�n">
        </form>
    <center>
        <H1>Carrito de la compra</H1>

        <form action="/proyecto_LucasSocrates_DominguezAgudo/miniForm" method="post">
            <!-- Formulario para enviar la solicitud de eliminaci�n -->
            <table border="0" cellpadding="0" width="75%" bgcolor="#FFFFFF">
                <tr>
                    <td><b>CD</b></td>
                    <td><b>Cantidad</b></td>
                    <td><b>Importe</b></td>
                    <td><b>Eliminar</b></td>
                    <!-- A�adimos una nueva columna para seleccionar qu� CDs eliminar -->
                </tr>

                <c:forEach items="${carrito.listaDiscos.entrySet()}" var="disco">
                    <tr>
                        <td><b><c:out value="${disco.key}"/></b></td>
                        <td><b><c:out value="${disco.value[0]}"/></b></td>
                        <td><b><c:out value="${disco.value[1]}"/>$</b></td>
                        <td><input type="checkbox" name="eliminar" value="${disco.key}"></td>
                    </tr>
                </c:forEach>


            </table>
            <H3>El precio final es de: <c:out value="${precioFinal}"/>$</H3>

            <p>
                <input type="submit" value="Eliminar"> <!-- Bot�n para enviar la solicitud de eliminaci�n -->
            </p>
        </form>
        <p>
            <a href="/proyecto_LucasSocrates_DominguezAgudo/index.html">Seguir Comprando</a>
        </p>
        <p>
            <a href="/proyecto_LucasSocrates_DominguezAgudo/login">Ir a pagar</a>
        </p>
    </center>
</body>
</html>
