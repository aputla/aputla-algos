package std.arrays.subarray_maximum_product;

public class Main {
    private static int product(int[] A, int p, int q) {
        int result = 1;
        for (int i = p; i <= q; i++) {
            result = result * A[i];
        }
        return result;
    }

    private static int F(int[] A, int p, int q) {
        int minus = 0;
        int first = -1;
        int last = -1;
        for (int i = p; i <= q; i++) {
            if (A[i] < 0 && first == -1) {
                first = i;
            }
            if (A[i] < 0) {
                minus++;
                last = i;
            }
        }
        if (minus % 2 == 0) {
            return product(A, p, q);
        }
        return Math.max(product(A, first + 1, q), product(A, p, last - 1));
    }

    private static int solve(int[] A) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (count != 0) {
                    result = Math.max(result, F(A, i - count, i - 1));
                    count = 0;
                }
            } else {
                count++;
            }
        }
        if (count != 0) {
            result = Math.max(result, F(A, A.length - count, A.length - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 1, 2, 3, 2, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(solve(A));
    }
}
