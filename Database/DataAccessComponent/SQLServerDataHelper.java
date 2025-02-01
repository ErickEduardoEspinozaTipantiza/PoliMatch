package DataAccessComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLServerDataHelper {
    private static String DBPathConnection = "jdbc:sqlserver://patware.database.windows.net:1433;database=PoliMatch;user=Ericks@patware;password=Patware.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static Connection connection = null;

    protected SQLServerDataHelper() {
    }

    protected static synchronized Connection openConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DBPathConnection);
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC de SQL Server.");
            throw e;
        } catch (SQLException e) {
            System.err.println("Error al conectar con SQL Server.");
            throw e;
        }
        return connection;
    }
}