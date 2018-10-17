package commands;

public class Unsuported implements Command {
    @Override
    public boolean canProcess(String command) {
        return true;
    }

    @Override
    public void process() {
        System.out.println("Command not found, try again");
    }
}
