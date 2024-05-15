package modelo;

import java.sql.*;

public class InicioSesion {

    private String username;
    private String passwd;

    public InicioSesion(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public Boolean realizarRegistro() {
        // Configurar la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/nombre_basedatos";
        String usuario = "usuario";
        String contraseña = "contraseña";

        try {
            // Establecer la conexión
            ConexionDB connect = new ConexionDB();

            Connection conexion = connect.obtenerConexion();
            // Consulta para verificar si el usuario ya existe

            String consulta = "SELECT COUNT(*) FROM usuarios WHERE username = ?";

            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                // Si el usuario no existe, insertarlo en la base de datos
                String insercion = "INSERT INTO usuarios (username, passwd) VALUES (?, ?)";
                pstmt = conexion.prepareStatement(insercion);
                pstmt.setString(1, username);
                pstmt.setString(2, passwd);

                pstmt.executeUpdate();

                System.out.println("Usuario registrado correctamente.");
                conexion.close();
                return true;
            }

            // Cerrar la conexión
            conexion.close();
            return false;

        } catch (SQLException e) {
            System.out.println("Error al realizar el registro: " + e.getMessage());
        }
        return false;
    }

    public boolean iniciarSesion() {
        // Variable para indicar si el inicio de sesión fue exitoso
        boolean inicioSesionExitoso = false;

        try {
            // Establecer la conexión
            ConexionDB connect = new ConexionDB();

            Connection conexion = connect.obtenerConexion();
            // Consulta para verificar si el usuario y contraseña son correctos
            String consulta = "SELECT COUNT(*) FROM usuarios WHERE username = ? AND passwd = ?";

            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, username);
            pstmt.setString(2, passwd);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 1) {
                // Si el usuario y contraseña son correctos, se inicia sesión exitosamente
                inicioSesionExitoso = true;
                System.out.println("Inicio de sesión exitoso.");
            } else {
                // Si el usuario y contraseña no son correctos, no se inicia sesión
                System.out.println("Usuario o contraseña incorrectos.");
            }

            // Cerrar la conexión
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }

        return inicioSesionExitoso;
    }

}
