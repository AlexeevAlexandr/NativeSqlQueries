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

    public void create() {
        try (Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            ResultSet rs1 = stmt.executeQuery("INSERT INTO demo (name) VALUES ('Vasiya') DECLARE @id int = scope_identity()" +
                    "INSERT INTO demo2 (id,password) VALUES (@id, '123456');");

            while (rs1.next()) {
                String name = rs1.getString("name");
                String password = rs1.getString("password");
                System.out.println(name + " " + password);
            }
        }catch (Exception e){e.printStackTrace();}
    }

}