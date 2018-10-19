package commands;

public class Help implements Command {

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("help");
    }

    @Override
    public void process() {
        System.out.println("List of available commands:");
        System.out.println(
                "list tables - show list of tables\n" +
                "create - add users\n" +
                "select - show list of users\n" +
                "select by id - view all info about user by id\n" +
                "clear - clear all data\n" +
                "q - exit\n");
    }
}
