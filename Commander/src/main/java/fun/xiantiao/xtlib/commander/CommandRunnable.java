package fun.xiantiao.xtlib.commander;

import java.util.function.Consumer;

public class CommandRunnable implements Runnable {
    private String[] args;
    private final Consumer<? super String[]> action;

    public CommandRunnable(Consumer<? super String[]> action) {
        this.action = action;
    }

    protected void setArgs(String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        action.accept(args);
    }
}
