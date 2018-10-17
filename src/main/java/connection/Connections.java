package connection;

import java.sql.*;

public class Connections {

    public java.sql.Connection connection_to_demo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        java.sql.Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC&useSSL=false";
            String user = "root";
            String password = "111111";
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}