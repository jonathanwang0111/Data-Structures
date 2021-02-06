import java.util.*;

public class PalindromePermutation {

    public static boolean check(Map map, String str) {
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (map.containsKey(x)) {
                int val = (int) map.get(x);
                val = val + 1;
                map.put(x, val);
            } else {
                map.put(x, 1);
            }
        }

        int oddCount = 0;
        Set keySet = map.keySet();
        Iterator<Character> iter = keySet.iterator();
        while (iter.hasNext()) {
            char x = iter.next();
            if ((int) map.get(x) % 2 == 1) {
                oddCount++;
            }
        }
        
        if (oddCount > 1) {
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String str = "aabbcd";
        System.out.println(check(map, str));
    }
}