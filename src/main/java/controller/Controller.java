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
        while (true) {
            System.out.println("Enter command or 'help' - for help, 'q' - for exit");
            Scanner scanner = new Scanner(System.in);
            String inputCommand = scanner.nextLine().toLowerCase();
            if (inputCommand.equals("q")) {
                System.out.println("Good by!");
                System.exit(0);
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