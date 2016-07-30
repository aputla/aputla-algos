package std.sorting.merge_sort;

import java.util.Arrays;

public class Main {
    private static void merge(int array[], int left, int middle, int right) {
        int A[] = Arrays.copyOfRange(array, left, middle + 1);
        int B[] = Arrays.copyOfRange(array, middle + 1, right + 1);
        
        int i = 0;
        int j = 0;
        int k = left;
        
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                array[k++] = A[i++];
            } else {
                array[k++] = B[j++];
            }
        }
 
        while (i < A.length) {
            array[k++] = A[i++];
        }
        while (j < B.length) {
            array[k++] = B[j++];
        }
    }
 
    private static void sort(int array[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
 
            sort(array, left, middle);
            sort(array, middle + 1, right);
 
            merge(array, left, middle, right);
        }
    }
 
    public static void main(String args[]) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(array));

        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
