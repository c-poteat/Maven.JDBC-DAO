package daos;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/testdb";
    public static final String USER = "testuser";
    public static final String PASS = "testpass";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver() {
                public Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }

                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }

                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                public int getMajorVersion() {
                    return 0;
                }

                public int getMinorVersion() {
                    return 0;
                }

                public boolean jdbcCompliant() {
                    return false;
                }

                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }

}

