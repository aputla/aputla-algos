package std.binary_search.find_max;

public class Main {
    private static int solve(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (true) {
            int mid = (low + high) / 2;
            if (A[low] <= A[mid]) {
                low = mid;
            } else {
                high = mid;
            }

            if (high - low <= 1) {
                return Math.max(A[low], A[high]);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        System.out.println(solve(A));
    }
}
