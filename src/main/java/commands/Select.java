package commands;

import connection.Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select implements Command {

    @Override
    public boolean canProcess(String command) {
        return command.equalsIgnoreCase("select");
    }

    @Override
    public void process() {
    Connections connections = new Connections();
        try (Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM demo;");
            while (rs.next())
            {
                System.out.println("========================");
                System.out.println("Id\t\t" + rs.getString("id"));
                System.out.println("Name\t" + rs.getString("name"));
            }
                System.out.println("========================");
        }catch (Exception e){e.printStackTrace();}
    }
}
