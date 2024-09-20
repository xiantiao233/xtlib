package fun.xiantiao.xtlib.commander;

import java.util.List;

public class Commander {
    public static void main(String[] args) {
        final String[] command_1 = {"add", "123"};
        final Runnable runnable_1 = () -> System.out.println("execute_1");
        CommandRecord record_1 = new CommandRecord(command_1, runnable_1);
        final String[] command_2 = {"add", null};
        final Runnable runnable_2 = () -> System.out.println("execute_2");
        CommandRecord record_2 = new CommandRecord(command_2, runnable_2);

        CommandRunning cr = new CommandRunning(record_1, record_2);

        cr.execute("add 000");
    }
}
