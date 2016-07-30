package std.math.integer_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    private static List<Integer> list = new ArrayList<Integer>();

    private static void permute(Integer[] A, int r) {
        int n = A.length;
        if (r == n) {
            System.out.println(Arrays.toString(A));
            return;
        }

        for (int i = r; i < n; i++) {
            swap(A, i, r);
            permute(A, r + 1);
            swap(A, i, r);
        }
    }

    private static void swap(Integer[] A, int i, int j) {
        Integer temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void F(int[] A, int current, int target, int r, int x, int y) {
        if (current > target) {
            return;
        }
        if (r == 0) {
            if (current == target) {
                Integer[] array = list.toArray(new Integer[]{});
                permute(array, 0);
            }
            return;
        }

        for (int i = x; i <= y; i++) {
            List<Integer> temp = new ArrayList<Integer>(list);
            list.add(A[i]);
            F(A, current + A[i], target, r - 1, i + 1, y + 1);
            list = temp;
        }
    }

    private static void solve(int[] A, int sum) {
        for (int i = 1; i < A.length; i++) {
            F(A, 0, sum, i, 0, A.length - i);
        }
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        solve(A, 7);
    }
}
