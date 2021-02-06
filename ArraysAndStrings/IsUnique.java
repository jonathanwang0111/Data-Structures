import java.util.*;

public class IsUnique {

    public static boolean method1(String input) {
        int len = input.length();
        char[] arr = new char[len];
        int arrIndex = 0;
        for (int i = 0; i < len; i++) {
            char x = input.charAt(i);
            for (int j = 0; j < arrIndex; j++) {
                if (x == arr[j]) {
                    return false;
                }
            }
            arr[arrIndex] = x;
            arrIndex++;
        }
        return true;
    }

    public static boolean method2(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /** NOTE: Remember how to use Scanners ... construct, nextLine, close */
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        System.out.println(method2(inputString));
        input.close();
    }
}