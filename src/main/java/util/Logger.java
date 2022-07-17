package util;

public class Logger {
    private Logger() {}
    public static void log(String s) {
        logInfo(s);
    }

    public static void log(int s) {
        logInfo(String.valueOf(s));
    }

    private static void logInfo(String s) {
        System.out.println("[" + Thread.currentThread().getName() + "] - [" + s + "]");
    }

}
