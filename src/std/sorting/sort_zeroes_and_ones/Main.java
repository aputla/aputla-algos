package std.sorting.sort_zeroes_and_ones;

import java.util.Arrays;

public class Main {
    private static void sort(int[] a) {
        int p = a.length - 1;
        
        for (int i = 0; i <= p;) {
            if (a[i] == 0) {
                i++;
            } else {
                swap(a, i, p);
                p--;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = {0, 1, 1, 1, 1, 0, 0, 1, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}

