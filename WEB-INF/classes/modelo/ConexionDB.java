package modelo;


/* Necesitamos importar este paquete para acceder al conector JDBC */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    /**
     * Comprueba si el driver de conexion JDBC de MySQL esta instalado
     */
    private void testDriver() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Encontrado el driver de PSQL");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("`SQL JDBC Driver no encontrado ... ");
            throw (e);
        }
    }

    /**
     * Devuelve conexion a PSQL
     *
     * @return
     * @throws java.lang.Exception
     */
    protected Connection obtenerConexion() {
        
        try {
            
            try {
                testDriver();
            } catch (Exception ex) {
                System.out.println("Excepcion comprobando el driver");
            }
            
            String url = "";
            url = "jdbc:postgresql://localhost:5432/minitienda";
            Connection con = DriverManager.getConnection(url, "lucas", "lucas");
            System.out.println("Conexion establecida con " + url + "...");
            return con;
        } catch (SQLException ex) {
        }
        return null;
    }

    /**
     * Este metodo ejecuta una sentencia de actualizacion sobre la base de datos
     *
     * @param con database connection
     * @param sqlStatement SQL DDL or DML statement to execute
     * @throws java.lang.Exception
     */
    protected void ejecutarOperacion(Connection con, String sqlStatement)
            throws Exception {
        try {
            Statement s = con.createStatement();
            s.execute(sqlStatement);
            s.close();
        } catch (SQLException e) {
            System.out.println("Error ejecutando sentencia SQL");
            throw (e);
        }
    }
}
