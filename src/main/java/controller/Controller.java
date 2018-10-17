package controller;

import commands.ListTables;

public class Controller {
    public static void main(String[] args) {
        ListTables listTables = new ListTables();
        System.out.println("Welcome!");
        listTables.listTables();


    }
}