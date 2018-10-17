package commands;

import connection.Connections;

import java.sql.ResultSet;
import java.sql.Statement;

public class Select implements Command {
    private Connections connections = new Connections();

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("select");
    }

    @Override
    public void process() {
        try (java.sql.Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            ResultSet rs = stmt.executeQuery("SELECT name, password FROM demo JOIN demo.demo2 ON demo.demo.id=demo.demo2.id");
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println("========================");
                System.out.println("Name\t\t" + name);
                System.out.println("Password\t" + password);
            }
                System.out.println("========================");
        }catch (Exception e){e.printStackTrace();}
    }
}
