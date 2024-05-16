package modelo;

import java.sql.*;

public class InicioSesion {

    private String username;
    private String passwd;
    private String tarjeta;
    private String tipo;

    public InicioSesion(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public InicioSesion(String username, String passwd, String tarjeta, String tipo) {
        this.username = username;
        this.passwd = passwd;
        this.tarjeta = tarjeta;
        this.tipo = tipo;
    }

    public Boolean realizarRegistro() {

        try {
            // Establecer la conexión
            ConexionDB connect = new ConexionDB();

            Connection conexion = connect.obtenerConexion();
            // Consulta para verificar si el usuario ya existe

            String consulta = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";

            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                // Si el usuario no existe, insertarlo en la base de datos
                String insercion = "INSERT INTO usuarios (correo, contraseña, tarjeta_credito, tipo_tarjeta) VALUES (?, ?, ?, ?)";
                pstmt = conexion.prepareStatement(insercion);
                pstmt.setString(1, username);
                pstmt.setString(2, passwd);
                pstmt.setString(3, tarjeta);
                pstmt.setString(4, tipo);

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
            String consulta = "SELECT COUNT(*) FROM usuarios WHERE correo = ? AND contraseña = ?";

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
            pstmt.close();
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        } finally {

        }

        return inicioSesionExitoso;
    }

}
