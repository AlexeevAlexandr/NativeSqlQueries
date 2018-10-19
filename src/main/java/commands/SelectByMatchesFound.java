package commands;

public class SelectByMatchesFound implements Command {
    @Override
    public boolean canProcess(String command) {
        return command.equalsIgnoreCase("find");
    }

    @Override
    public void process() {

    }
}
