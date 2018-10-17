package commands;

import connection.Connections;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Create implements Command{

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("create");
    }

    @Override
    public void process() {
        Connections connections = new Connections();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Enter name");
            String name = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            try (Connection connection = connections.connection_to_demo();
                 Statement stmt = connection.createStatement())
            {
                stmt.executeUpdate("INSERT INTO demo (name) VALUES ('" + name + "');");
                stmt.executeUpdate("INSERT INTO demo2 (password) VALUES ('" + password + "');");
                System.out.println("Successful");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Continue (y/n)");
            String confirm = scanner.nextLine().toLowerCase();
            if (!confirm.equals("y")){
                check = false;
            }
        }
    }

}
