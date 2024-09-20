package fun.xiantiao.xtlib.commander;

public class Commander {
    public static void main(String[] a) {
        CommandRecord record_1 = new CommandRecord(new String[]{"version"},
                new CommandRunnable((args) -> {
                    System.out.println("xtlib commander 1.0.0 by xiantiao");
                })
        );
        CommandRecord record_2 = new CommandRecord(new String[]{"unban", null},
                new CommandRunnable((args) -> {
                    System.out.println("unbanned ["+args[0]+"]");
                })
        );
        CommandRecord record_3 = new CommandRecord(new String[]{"ban", null, "true"},
                new CommandRunnable((args) -> {
                    System.out.println("banned: "+args[0]);
                })
        );

        CommandRunning runner = new CommandRunning(
                record_1,
                record_2,
                record_3
        );

        runner.execute("version");
        runner.execute("unban xiantiao");
        runner.execute("ban xiantiao true");
    }
}
