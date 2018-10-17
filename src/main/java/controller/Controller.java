package controller;

import commands.ListTables;
import queries.Queries;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Queries queries = new Queries();
        String availableCommands = "" +
                "list - show list of tables\n" +
                "add - add username and password";
        System.out.println("Welcome!");
        System.out.println("List of commands what you can use:");
        System.out.println(availableCommands);

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        switch (command){
            case ("list"):
        }


    }
}