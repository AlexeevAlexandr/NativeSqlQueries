package commands;

import connection.Connections;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Clear implements Command {

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("clear");
    }

    @Override
    public void process() {
        System.out.println("Confirm deletion (y/n)");
        String confirm = new Scanner(System.in).nextLine().toLowerCase();
        if (confirm.equals("y")) {
            Clear clear = new Clear();
            clear.clearData();
        }else {
            System.out.println("Canceled");
        }
    }

    private void clearData(){
        Connections connections = new Connections();
        try (Connection connection = connections.connection_to_demo();
             Statement stmt = connection.createStatement())
        {
            stmt.executeUpdate("TRUNCATE TABLE demo;");
            stmt.executeUpdate("TRUNCATE TABLE demo2;");
            System.out.println("Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
