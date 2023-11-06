package conexion;

/**
 *
 * @author Luis Silvestre
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_MySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/ProyectoBaseDeDatos";
    private static final String USER = "root";
    private static final String PASSWORD = "Orion1";

    String url = "jdbc:mysql://localhost:3306/ProyectoBaseDeDatos";
    String usuario = "root";
    String contraseña = "Orion1";

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Establece la conexión a la base de datos MySQL.
            String url = "jdbc:mysql://localhost:3306/ProyectoBaseDeDatos";
            String usuario = "root";
            String contraseña = "Orion1";
            conn = DriverManager.getConnection(url, usuario, contraseña);
            Connection connection = null;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
