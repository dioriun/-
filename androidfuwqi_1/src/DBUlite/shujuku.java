package DBUlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class shujuku {
    private static Connection conn = null;
    private static String URl = "jdbc:mysql://localhost:3306/student?serverTimezone=GMT%2B8";
    private static String username = "root";
    private static String password = "root";

    public shujuku() {
    }

    public static Connection conn() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URl, username, password);
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return conn;
    }

    public static void Close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException var1) {
            var1.printStackTrace();
        }

    }
public static void main(String[] args) {
    conn();
}

}
