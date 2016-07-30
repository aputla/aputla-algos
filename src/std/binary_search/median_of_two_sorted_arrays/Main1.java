package std.binary_search.median_of_two_sorted_arrays;

class Main1 {
    private static double solve(int[] A, int[] B) {
        int n = A.length + B.length;
        int m[] = {n / 2, n / 2 + (n + 1) % 2};
        double ans = 0;
        int i = 0;
        int j = 0;
        while (true) {
            int num = 0;
            if (i < A.length && j < B.length) {
                num = (A[i] <= B[j]) ? A[i++] : B[j++];
            } else if (i < A.length) {
                num = A[i++];
            } else if (j < B.length) {
                num = B[j++];
            }
            if (i + j == m[0]) {
                ans = num;
            }
            if (i + j == m[1]) {
                ans += num;
                break;
            }
        }
        return ans / 2;
    }

    public static void main(String[] args) { 
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 10};
        
        System.out.println(solve(A, B));
    }       
}
