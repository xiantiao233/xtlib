package fun.xiantiao.xtlib.commander;

import java.util.function.Consumer;

public class CommandRecord {
    private final Runnable execute;
    private final String[] command;

    public CommandRecord(String[] command, Runnable execute) {
        this.execute = execute;
        this.command = command;
    }

    public Runnable getRunnable() {
        return execute;
    }

    public String[] getCommand() {
        return command;
    }
}
