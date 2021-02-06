import java.util.*;

public class TripleStep {
    public static int numCombos(int n) {
        int[] memo = new int[100];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        return numCombos(n, memo);
    }

    public static int numCombos(int n, int[] memo) {
        if (n < 4) {
            return memo[n];
        }
        if (memo[n] == 0) {
            memo[n] = numCombos(n - 1, memo) + numCombos(n - 2, memo) + numCombos(n - 3, memo);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(numCombos(4));
    }
}