package fun.xiantiao.xtlib.commander;

public class CommandRecord  {
    private final CommandRunnable execute;
    private final String[] command;

    public CommandRecord(String[] command, CommandRunnable execute) {
        this.execute = execute;
        this.command = command;
    }

    public CommandRunnable getRunnable() {
        return execute;
    }

    public String[] getCommand() {
        return command;
    }

}
