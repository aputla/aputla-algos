package std.math.sieve_of_eratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<Integer> solve(int n) {
        boolean[] P = new boolean[n + 1];
        Arrays.fill(P, true);
        P[0] = false;
        P[1] = false;
        int m = (int) Math.sqrt(n);

        for (int i = 2; i <= m; i++) {
            for (int j = 2 * i; P[i] && j <= n; j += i) {
                P[j] = false;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < P.length; i++) {
            if (P[i]) {
                result.add(i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> list = solve(1000);
        System.out.println(list);
    }
}
