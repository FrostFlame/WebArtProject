package Singletons;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 1 on 03.10.2016.
 */
public class ConnectionSingleton {
    private static Connection conn = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/Task2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "vzlomchik";
    private static final String DRIVER = "org.postgresql.Driver";

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
