package std.sorting.bubble_sort;

import java.util.Arrays;

public class Main {    
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = {2, 1, 7, 8, 3, 4, 6, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
