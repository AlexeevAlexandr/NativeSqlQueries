package commands;

import connection.Connections;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectByMatchesFound implements Command {
    @Override
    public boolean canProcess(String command) {
        return command.equalsIgnoreCase("find");
    }

    @Override
    public void process() {
        Connections connections = new Connections();
        boolean check = true;
        while (check) {
            try (java.sql.Connection connection = connections.connection_to_demo();
                 Statement stmt = connection.createStatement())
            {
                System.out.println("Enter column name");
                String string1 = new Scanner(System.in).nextLine();
                System.out.println("Enter the required information");
                String string2 = new Scanner(System.in).nextLine();
                ResultSet rs = stmt.executeQuery(
                        "SELECT demo.id, name, email, date, password FROM demo " +
                                "JOIN demo.demo2 ON demo.demo.id=demo.demo2.id WHERE demo." + string1 + " LIKE '%" + string2 + "%';");
                while (rs.next()) {
                    System.out.println("========================");
                    System.out.println("Id\t\t\t" + rs.getString("id"));
                    System.out.println("Name\t\t" + rs.getString("name"));
                    System.out.println("email\t\t" + rs.getString("email"));
                    System.out.println("date\t\t" + rs.getString("date"));
                    System.out.println("Password\t" + rs.getString("password"));
                }
                System.out.println("========================");
                System.out.println("Continue (y/n)?");
                String string = new Scanner(System.in).nextLine().toLowerCase();
                if (!string.equals("y")){
                    check = false;
                }
            }catch (Exception e){ e.printStackTrace(); }
        }
    }
}
