package commands;

public interface Command {

    boolean canProcess(String command);

    void process();
}
