package std.dynamic_programming.max_subsequence_sum;

public class MainDP {
    private static int solve(int[] A) {
        int[] F = new int[A.length];
        int result = 0;

        F[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            F[i] = Math.max(F[i - 1] + A[i], A[i]);
            result = Math.max(F[i], result);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, -9, 4, 5};
        System.out.println(solve(A));
    }
}
