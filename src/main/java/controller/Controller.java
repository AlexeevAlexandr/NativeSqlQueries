package controller;

import queries.Queries;

public class Controller {
    public static void main(String[] args) {
        Queries queries = new Queries();
        queries.select();
        queries.create();
    }
}