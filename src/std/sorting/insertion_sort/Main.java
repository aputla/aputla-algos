package std.sorting.insertion_sort;

import java.util.Arrays;
 
public class Main {
    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
 
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 6, 8, 7, 9, 0, 3, 2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
