package std.dynamic_programming.cc_ca_cv_2;

public class Solution {
    private static long solve(int n) {
        long[] F = new long[n + 1];
        F[0] = 0;
        for (int i = 1; i <= n; i++) {
            F[i] = Math.max(F[i], F[i - 1] + 1);
            for (int j = i + 1; i >= 3 && j <= n; j++) {
                F[j] = Math.max(F[j], (j - i + 1) * F[i - 3]);
            }
        }
        return F[n];
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + ":" + solve(i));
        }
    }
}
