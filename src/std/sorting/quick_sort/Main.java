package std.sorting.quick_sort;

import java.util.Arrays;

public class Main {
    private static int partition(int array[], int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        };
        return i;
    }

    private static void quicksort(int array[], int left, int right) {
        int index = partition(array, left, right);

        if (left < index - 1) {
            quicksort(array, left, index - 1);
        }

        if (index < right) {
            quicksort(array, index, right);
        }
    }

    private static void swap(int array[], int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int array[] = {5, 4, 1, 3, 2};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
