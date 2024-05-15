<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title>
    </head>
    <body>
        <h2>Registro</h2>
        <form action="/minitienda/caja" method="get">
            <div>
                <label for="usernameReg">Usuario:</label>
                <input type="text" id="usernameReg" name="usernameReg" required>
            </div>
            <div>
                <label for="passwordReg">Contraseña:</label>
                <input type="password" id="passwordReg" name="passwordReg" required>
            </div>
            <button type="submit">Registrarse</button>
        </form>
        <p>¿Ya tienes una cuenta? <a href="/minitienda/login">Regístrate</a></p>

    </body>
</html>
