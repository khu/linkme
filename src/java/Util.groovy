public class Util {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String defaultString(String a) {
        if (a == null || a.trim() == "") {
            return "";
        }
        return a.trim();
    }
}
