package std.dynamic_programming.longest_non_decreasing_subsequence;

import java.util.Arrays;

public class Main {
    private static int solve(int[] A) {
        int n = A.length;
        int[] F = new int[n];

        Arrays.fill(F, 1);
        int result = 1;
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < i; k++) {
                if (A[i] >= A[k]) {
                    F[i] = Math.max(F[i - 1], F[k] + 1);
                }
                result = Math.max(result, F[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 5, 1, 2};
        System.out.println(solve(A));
    }
}

