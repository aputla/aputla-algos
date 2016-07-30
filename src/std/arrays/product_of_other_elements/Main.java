package std.arrays.product_of_other_elements;

import java.util.Arrays;

public class Main {
    private static int[] solve(int[] A) {
        int[] X = new int[A.length];
        int P = 1;
        for (int i = 0; i < A.length; i++) {
            X[i] = P;
            P *= A[i];
        }
        P = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int T = A[i];
            A[i] = X[i] * P;
            P = P * T;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 2, 3};
        System.out.println(Arrays.toString(solve(A)));
    }
}
