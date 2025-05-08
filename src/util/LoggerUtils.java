package util;

public final class LoggerUtils {

    // Private constructor to prevent instantiation
    private LoggerUtils() {
        throw new UnsupportedOperationException("util.LoggerUtils is a utility class and cannot be instantiated.");
    }

    public static void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void success(String message) {
        System.out.println("[SUCCESS] ✅ " + message);
    }

    public static void warning(String message) {
        System.out.println("[WARNING] ⚠️ " + message);
    }

    public static void error(String message) {
        System.err.println("[ERROR] ❌ " + message);
    }

    public static void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
