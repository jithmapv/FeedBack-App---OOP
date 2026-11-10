import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException {
        String url = requiredEnvironmentVariable("FEEDBACK_DB_URL");
        String username = requiredEnvironmentVariable("FEEDBACK_DB_USERNAME");
        String password = requiredEnvironmentVariable("FEEDBACK_DB_PASSWORD");

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    private static String requiredEnvironmentVariable(String name) throws SQLException {
        String value = System.getenv(name);
        if (value == null || value.trim().isEmpty()) {
            throw new SQLException("Missing database configuration: " + name);
        }
        return value;
    }
}
