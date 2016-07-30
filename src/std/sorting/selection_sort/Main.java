package std.sorting.selection_sort;

import java.util.Arrays;
 
public class Main {
    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minindex]) {
                    minindex = j;
                }
            }
            swap(a, i, minindex);
        }
    }
    
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 6, 8, 7, 9, 0, 3, 2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
