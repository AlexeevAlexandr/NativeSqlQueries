package controller;

import connection.Connections;
import queries.Queries;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Queries queries = new Queries();
        Connections connections = new Connections();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;

        System.out.println("Welcome!");
        while (check){
            String string;
            System.out.println("List of tables what you can use:");
            queries.listTables();
            System.out.println("Make your choice or 'q' to exit");
            string = scanner.nextLine();
            if ((string.toLowerCase()).equals("q")){
                check = false;
            }

        }


    }
}