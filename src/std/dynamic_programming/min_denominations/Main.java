package std.dynamic_programming.min_denominations;

public class Main {
    private static int solve(int[] A, int V) {
        int F[] = new int[V + 1];

        for (int i = 0; i < F.length; i++) {
            F[i] = Integer.MAX_VALUE;
        }

        F[0] = 0;
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i - A[j] >= 0) {
                    F[i] = Math.min(F[i], F[i - A[j]] + 1);
                }
            }
        }
        return F[V];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 8, 11};
        System.out.println(solve(array, 23));
    }
}
