<%@page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Confirmación de Pedido</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vista/css/pedidoRealizado.css">    </head>
    <body>
        <div class="container">
            <h2>Confirmación de Pedido</h2>
            <p>¡Tu pedido se ha realizado correctamente!</p>

            <h3>Discos Comprados</h3>
            <table>
                <tr>
                    <th>Pedido</th>
                </tr>
                <c:forEach items="${carro.listaDiscos.keySet()}" var="disco">
                    <tr>
                        <td><c:out value="${disco}" /></td>
                    </tr>
                </c:forEach>
            </table>

            <h3>Total a Pagar</h3>
            <p><c:out value="${pagoFinal}" /> $</p>

            <p><a href="/proyecto_LucasSocrates_DominguezAgudo/index.html">Seguir Comprando</a></p>
        </div>
    </body>
</html>
