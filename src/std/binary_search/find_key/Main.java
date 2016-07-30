package std.binary_search.find_key;

public class Main {
    private static int solve(int[] A, int k) {
        int low = 0;
        int high = A.length - 1;

        while (true) {
            int mid = (low + high) / 2;
            
            if (A[mid] == k) {
                return mid;
            } else if (A[low] <= k && k <= A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {5, 6, 7, 9, 11, 0, 1, 2, 3, 4};
        System.out.println(solve(A, 4));
    }
}
