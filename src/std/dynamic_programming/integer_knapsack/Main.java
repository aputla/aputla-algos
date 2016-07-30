package std.dynamic_programming.integer_knapsack;

public class Main {
    
    private static int solve(int[] W, int[] V, int C) {
        int[][] F = new int[W.length][];
        for (int i = 0; i < F.length; i++) {
            F[i] = new int[C + 1];
        }   
        
        F[0][W[0]] = V[0];
        for (int i = 1; i < W.length; i++) {
            for (int j = 0; j <= C; j++) {
                F[i][j] = F[i - 1][j];
                if (j - W[i] >= 0 && F[i][j] < F[i - 1][j - W[i]] + V[i]) {
                    F[i][j] = F[i - 1][j - W[i]] + V[i];
                }
            }
        }
        
        int result = F[F.length - 1][0];
        for (int i = 1; i <= C; i++) {
            result = Math.max(result, F[F.length - 1][i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] S = {1, 2, 3, 4, 8, 7, 6, 10};
        int[] V = {1, 2, 3, 4, 10, 7, 6, 100};
        
        System.out.println(solve(S, V, 10));
    }
}
