package std.sorting.sort_zeroes_ones_and_twos;

import java.util.Arrays;

public class Main {
    private static void solve(int[] array) {
        int p = 0;
        int q = array.length - 1;
        for (int i = 0; i < q;) {
            if (array[i] == 0) {
                swap(array, i, p); 
                i++;
                p++;
            } else if (array[i] == 1) {
                i++;
            } else {
                swap(array, i, q);
                q--;
            }
        }
    }
 
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0};
        solve(array);
        System.out.println(Arrays.toString(array));
    }
}
