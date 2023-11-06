package conexion;

/**
 *
 * @author Luis Silvestre
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/ProyectoBaseDeDatos";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "Orion1";

    String url = "jdbc:mysql://localhost:3306/ProyectoBaseDeDatos";
    String usuario = "root";
    String contraseña = "Orion1";

    private Connection conexion;

    public ConexionMySQL() {
        try {
            // Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error en la conexión a la base de datos", e);
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cerrar la conexión", e);
        }
    }
}
