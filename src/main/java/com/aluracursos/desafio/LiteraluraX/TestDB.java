import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/literalurax";
        String username = "postgres";
        String password = "qpqp";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexión exitosa a la base de datos: " + connection.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
