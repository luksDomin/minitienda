package modelo;

import java.sql.*;
import java.util.Set;

public class Pagar {

    //modificar esta clase
    public Boolean realizarPedido(String correo, Set<String> discos, float precioFinal) {

        try {
            // Establecer la conexión
            ConexionDB connect = new ConexionDB();

            Connection conexion = connect.obtenerConexion();
            // Consulta para verificar si el usuario ya existe
            String consulta = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";

            PreparedStatement pstmt = conexion.prepareStatement(consulta);
            pstmt.setString(1, correo);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 1) {
                // Si el usuario existe, insertar su pedido en la base de datos

                String compra = "";

                for (String cd : discos) {
                    compra += cd + "//";
                }

                String insercion = "INSERT INTO pedidos (correo, lista_discos, precio_pagar) VALUES (?, ?, ?)";
                pstmt = conexion.prepareStatement(insercion);
                pstmt.setString(1, correo);
                pstmt.setString(2, compra);
                pstmt.setFloat(3, precioFinal);

                pstmt.executeUpdate();

                System.out.println("Pedido registrado correctamente.");
                conexion.close();
                return true;
            }

            // Cerrar la conexión
            conexion.close();
            return false;

        } catch (SQLException e) {
            System.out.println("Error al realizar el pedido: " + e.getMessage());
        }
        return false;
    }
}
