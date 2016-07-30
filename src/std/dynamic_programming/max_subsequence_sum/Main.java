package std.dynamic_programming.max_subsequence_sum;

public class Main {
    private static int solve(int[] array) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < 0) {
                sum = 0;
            }
            if (result < sum) {
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, -1, -2, 4};
        System.out.println(solve(array));
    }
}
