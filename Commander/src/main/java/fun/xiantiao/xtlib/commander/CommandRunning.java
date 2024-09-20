package fun.xiantiao.xtlib.commander;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CommandRunning {
    private final @NotNull Set<CommandRecord> commandRecords = new HashSet<>();

    public CommandRunning(@NotNull CommandRecord... commandRecord) {
        commandRecords.addAll(Arrays.asList(commandRecord));
    }

    public void execute(@NotNull String command) {
        String[] split = command.split(" ");
        CommandRunnable runnable = getRunnable(split);
        if (runnable != null) runnable.run();
    }

    private @Nullable CommandRunnable getRunnable(String[] split) {
        final Set<CommandRecord> commandRecords = getLengthSame(split);
        for (CommandRecord commandRecord : commandRecords) {
            String[] recordCommand = commandRecord.getCommand();
            if (isEquals(recordCommand, split)) {
                CommandRunnable runnable = commandRecord.getRunnable();
                String[] args = getArgs(recordCommand, split);
                runnable.setArgs(args);
                return commandRecord.getRunnable();
            }
        }
        return null;
    }

    private String[] getArgs(String[] benchmarks, String[] split) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < benchmarks.length; i++) {
            if (benchmarks[i] == null) {
                list.add(split[i]);
            }
        }
        return list.toArray(new String[0]);
    }

    private boolean isEquals(String[] benchmarks, String[] split2) {
        int length = benchmarks.length;
        for (int i = 0; i < length; i++) {
            if (benchmarks[i] == null) continue;
            if (benchmarks[i] != null && benchmarks[i].equals(split2[i])) continue;
            if (benchmarks[i] != null && !benchmarks[i].equals(split2[i])) return false;
        }
        return true;
    }

    private @NotNull Set<CommandRecord> getLengthSame(String[] split) {
        Set<CommandRecord> same = new HashSet<>();
        for (CommandRecord commandRecord : commandRecords) {
            String[] recordCommand = commandRecord.getCommand();
            if (recordCommand != null && recordCommand.length == split.length) {
                same.add(commandRecord);
            }
        }
        return same;
    }
}
