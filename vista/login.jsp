<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Sesi�n</title>
    </head>
    <body>
        <h2>Iniciar Sesi�n</h2>
        <form action="/minitienda/caja" method="get">
            <div>
                <label for="usernameLogin">Usuario:</label>
                <input type="text" id="usernameLogin" name="usernameLogin" required>
            </div>
            <div>
                <label for="passwordLogin">Contrase�a:</label>
                <input type="password" id="passwordLogin" name="passwordLogin" required>
            </div>
            <button type="submit">Iniciar Sesi�n</button>
        </form>
        <p>�No tienes una cuenta? <a href="/minitienda/registro">Reg�strate</a></p>
    </body>
</html>
