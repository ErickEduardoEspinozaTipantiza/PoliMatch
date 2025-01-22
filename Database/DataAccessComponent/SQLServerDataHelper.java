package DataAccessComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLServerDataHelper {
    // Cambia esta cadena de conexión con los valores adecuados para tu SQL Server.
    private static String DBPathConnection = "jdbc:sqlserver://DESKTOP-INJS97N:1433;databaseName=POLITINDER";
    private static Connection connection = null;

    protected SQLServerDataHelper() {
    }

    protected static synchronized Connection openConnection() throws Exception {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DBPathConnection);
            }
        } catch (SQLException e) {
            throw e;
        }
        return connection;
    }
}
