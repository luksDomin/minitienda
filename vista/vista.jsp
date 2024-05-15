<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashMap" %> <!-- Importar HashMap -->
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map.Entry" %>

<% 
    HashMap<String, Integer> listaDiscosSesion = (HashMap<String, Integer>) session.getAttribute("listaDiscosSesion"); 
%>


<!DOCTYPE HTML>
<HTML>
    <HEAD>
        <TITLE>Carrito</TITLE>
    </HEAD>
    <BODY>
    <center>
        <H1>Carrito de la compra</H1>

        <form action="/minitienda/miniForm" method="get">
            <!-- Formulario para enviar la solicitud de eliminación -->
            <table border="0" cellpadding="0" width="75%" bgcolor="#FFFFFF">
                <tr>
                    <td><b>CD</b></td>
                    <td><b>Cantidad</b></td>
                    <td><b>Importe</b></td>
                    <td><b>Eliminar</b></td>
                    <!-- Añadimos una nueva columna para seleccionar qué CDs eliminar -->
                </tr>

                <c:forEach items="${carrito.listaDiscos.entrySet()}" var="disco">
                    <tr>
                        <td><b><c:out value="${disco.key}"/></b></td>
                        <td><b><c:out value="${disco.value[0]}"/></b></td>
                        <td><b><c:out value="${disco.value[1]}"/></b></td>
                        <td><input type="checkbox" name="eliminar" value="${disco.key}"></td>
                    </tr>
                </c:forEach>


            </table>
            <H3><c:out value="${precioFinal}"/></H3>

            <p>
                <input type="submit" value="Eliminar"> <!-- Botón para enviar la solicitud de eliminación -->
            </p>
        </form>
        <p>
            <a href="/minitienda/index.html">Seguir Comprando</a>
        </p>
        <p>
            <a href="/minitienda/login">Ir a pagar</a>
        </p>
    </center>
</body>
</html>
