package conexion;

/**
 *
 * @author Luis Silvestre
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_1 {

    // Constantes para la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/ProyectoBaseDeDatos";
    private static final String USER = "root";
    private static final String PASSWORD = "Orion1";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establece la conexión a la base de datos MySQL.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // Realiza operaciones con la conexión si es necesario
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            // Cierra la conexión en el bloque finally para asegurar que se cierre correctamente.
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    // Conexión local
    public static Connection conectar() {
        try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_ventas", "root", "1234")) {
            return cn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexión local: " + e.getMessage());
        }
        return null;
    }
}
