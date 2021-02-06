import java.util.*;

public class CheckPermutation {

    public static boolean check(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            boolean changed = false;
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    String prefix = str2.substring(0, j);
                    String suffix = str2.substring(j + 1);
                    str2 = prefix + suffix;
                    changed = true;
                }
            }
            if (!changed) {
                return false;
            }
        }
        if (str2.length() > 0) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(check("aabc", "baac"));
    }
}