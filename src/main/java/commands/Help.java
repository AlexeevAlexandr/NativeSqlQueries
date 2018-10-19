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
                "help - for help\n" +
                "list tables - show list of tables\n" +
                "create - add username and password\n" +
                "select - show list of users\n" +
                "q - exit\n");
    }
}
