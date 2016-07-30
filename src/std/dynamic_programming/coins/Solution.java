package std.dynamic_programming.coins;

public class Solution {
    private static int solve(int[] v, int S) {
        int[] M = new int[S + 1];
        M[0] = 0;
        for (int i = 1; i <= S; i++) {
            M[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= S; i++) {
            for (int j = 0; j < v.length; j++) {
                if (i - v[j] >= 0 && M[i - v[j]] + 1 < M[i]) {
                    M[i] = M[i - v[j]] + 1;
                }
            }
        }
        return M[S];
    }
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 3, 5}, 11));
    }
}
