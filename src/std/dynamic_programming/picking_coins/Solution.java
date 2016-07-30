package std.dynamic_programming.picking_coins;

public class Solution {
    private static int[][] M;
    private static int F(int[] V, int i, int j) {
        if (i == j) {
            return V[i];
        }
        if (M[i][j] != 0) {
            return M[i][j];
        }
        int a = V[i] + Math.min(F(V, i + 2, j), F(V, i + 1, j - 1));
        int b = V[j] + Math.min(F(V, i, j - 2), F(V, i + 1, j - 1));
        return (M[i][j] = Math.max(a, b));
    }

    public static void main(String[] args) {
        int[] V = {1, 2, 3};
        M = new int[V.length][V.length];
        System.out.println(F(V, 0, V.length - 1));
    }
}
