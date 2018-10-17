package queries;

import connection.Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Queries {
    private Connections connections = new Connections();

    public void select() {
        try (java.sql.Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            ResultSet rs = stmt.executeQuery("SELECT name, password FROM demo JOIN demo.demo2 ON demo.demo.id=demo.demo2.id");
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println(name + " " + password);
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void create(String name, String password) {
        try (Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            stmt.executeUpdate("INSERT INTO demo (name) VALUES ('" + name + "');");
            stmt.executeUpdate("INSERT INTO demo2 (password) VALUES ('" + password + "');");
        }catch (Exception e){e.printStackTrace();}
    }

}