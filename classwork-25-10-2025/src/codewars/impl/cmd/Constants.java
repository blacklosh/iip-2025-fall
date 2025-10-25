package codewars.impl.cmd;

public final class Constants {

    public static int BLOCK_SIZE;

    private static long nextId = 1;

    private Constants() {

    }

    public static long getNextId() {
        return nextId++;
    }
}
