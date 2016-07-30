package std.sorting.inversion_count;

public class BruteForce {
    private static int print_inversion_count(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    result += 1;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int array[] = {2, 4, 1, 3, 4};
        System.out.println(print_inversion_count(array));
    }
}
