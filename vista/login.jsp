<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <h2>Iniciar Sesión</h2>
        <form action="/minitienda/caja" method="get">
            <div>
                <label for="usernameLogin">Usuario:</label>
                <input type="text" id="usernameLogin" name="usernameLogin" required>
            </div>
            <div>
                <label for="passwordLogin">Contraseña:</label>
                <input type="password" id="passwordLogin" name="passwordLogin" required>
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
        <p>¿No tienes una cuenta? <a href="/minitienda/registro">Regístrate</a></p>
    </body>
</html>
