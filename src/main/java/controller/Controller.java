package controller;

import commands.*;

import java.util.Scanner;

class Controller {

    private Command [] commands;

    Controller(){
        this.commands = new Command[]{
                new Create(),
                new Select(),
                new Help(),
                new ListTebles(),
                new Unsuported()};
    }

    void run(){
        try {
            doWork();
        }catch (Exception e){/*do nothing*/}
    }

    private void doWork() {
        System.out.println("Welcome!");
        boolean check = true;
        while (check) {
            System.out.println("Enter command or 'help' - for help");
            Scanner scanner = new Scanner(System.in);
            String inputCommand = scanner.nextLine().toLowerCase();
            if (inputCommand.equals("q")) {
                check = false;
            }
            for (Command command : commands) {
                if (command.canProcess(inputCommand)) {
                    command.process();
                    break;
                }
            }
        }
    }
}