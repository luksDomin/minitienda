<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesi�n</title>
</head>
<body>
    <h2>Iniciar Sesi�n</h2>
    <form action="/caja" method="get">
        <div>
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Contrase�a:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Iniciar Sesi�n</button>
    </form>
    <p>�No tienes una cuenta? <a href="/registro">Reg�strate</a></p>
</body>
</html>
