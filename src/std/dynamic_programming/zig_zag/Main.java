package std.dynamic_programming.zig_zag;

import java.util.Arrays;

public class Main {
    public static int solve(int[] A) {
        int n = A.length;
        int F[] = new int[n];
        int G[] = new int[n];
        
        Arrays.fill(F, 1);
        Arrays.fill(G, 1);
        
        int result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    F[i] = Math.max(F[i], G[j] + 1);
                } else if (A[i] < A[j]) {
                    G[i] = Math.max(G[i], F[j] + 1);
                }
                result = Math.max(result, F[i]);
                result = Math.max(result, G[i]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int array[] = {9, 2, 7, 6, 4, 8, 1};
        System.out.println(solve(array));
    }
}

