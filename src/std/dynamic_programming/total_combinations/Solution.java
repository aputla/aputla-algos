package std.dynamic_programming.total_combinations;

import java.util.Arrays;

public class Solution {
    private static int F(int[] A, int N) {
        int[] M = new int[N + 1];
        
        M[0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (j - A[i] >= 0) {
                    M[j] += M[j - A[i]];
                }
            }
            System.out.println(A[i] + " " + Arrays.toString(M));
        }
        return M[N];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 5, 10};
        int N = 5;

        System.out.println(F(A, N));
    }
}
