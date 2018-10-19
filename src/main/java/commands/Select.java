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
            ResultSet rs = stmt.executeQuery("SELECT demo.id, name, email, date, password FROM demo JOIN demo.demo2 ON demo.demo.id=demo.demo2.id");
            while (rs.next()) {
                System.out.println("========================");
                System.out.println("Id\t\t\t" + rs.getString("id"));
                System.out.println("Name\t\t" + rs.getString("name"));
                System.out.println("email\t\t" + rs.getString("email"));
                System.out.println("date\t\t" + rs.getString("date"));
                System.out.println("Password\t" + rs.getString("password"));
            }
                System.out.println("========================");
        }catch (Exception e){e.printStackTrace();}
    }
}
