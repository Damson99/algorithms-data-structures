package util;

public class Logger {
    private Logger() {}
    public static void log(String s) {
        logWithParse(s);
    }

    public static void log(int s) {
        logWithParse(String.valueOf(s));
    }

    private static void logWithParse(String s) {
        System.out.println("[" + Thread.currentThread().getName() + "] - [" + s + "]");
    }

}
