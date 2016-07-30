package std.binary_search.median_of_two_sorted_arrays;

class Main2 {
    private static double solve(int[] A, int[] B) {
        int lo1 = 0;
        int hi1 = A.length - 1;
        int lo2 = 0;
        int hi2 = B.length - 1;

        while (true) {
            int m1 = (lo1 + hi1) / 2;
            int m2 = (lo2 + hi2) / 2;

            if (lo1 + 1 == hi1 && lo2 + 1 == hi2) {
                return (Math.max(A[lo1], B[lo2]) + Math.min(A[hi1], B[hi2])) / 2.0;
            }

            if (A[m1] < B[m2]) {
                lo1 = m1;
                hi2 = m2;
            } else if (A[m1] > B[m2]) {
                hi1 = m1;
                lo2 = m2;
            } else {
                return A[m1];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 10};

        System.out.println(solve(A, B));
    }
}
