package commands;

import connection.Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListTebles implements Command {
    private Connections connections = new Connections();

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("list tables");
    }

    @Override
    public void process() {
        try (Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            stmt.executeQuery("SHOW TABLES");
            ResultSet rs = stmt.getResultSet();
            System.out.println("====================");
            while (rs.next()) {
                System.out.println(rs.getString("Tables_in_demo"));
            }
                System.out.println("====================");
        }catch (Exception e){e.printStackTrace();}
    }
}